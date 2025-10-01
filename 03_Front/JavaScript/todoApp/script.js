
/*
    localStorage
    -브라우저에 key-value형태로 데이터를 저장할 수 있는 공간
    -저장된 데이터는 브라우저를 껐다 켜도 유지가되며,도메인별로 저장이 된다.
    - 최대 저장용량은 5MB(브라우저별로 다를 수 있음)



localStorage.setItem(key,value); //데이터저장
localStorage.getItem(key); // 데이터를 불러올때
localStorage.removeItem(key); //데이터를 삭제
localStorage.clear(); // 모든테이터 삭제
--문자열만 저장하고 가져올 수 있다

JSON.stringify(js객체) -> JSON문자열로 변환
JOSN.parsr(문자열) -> js객체로 복원
*/


//======== 전역 변수 ================================================
//할일 목록을 저장하는 배열 - 여러함수에서 공유해야하기떄문에  전역으로 선언

let todos =JSON.parse(localStorage.getItem('todos')) || [];
let filterState='all';


// ======= DOM 요소 =================================================
const todoList = document.getElementById("todo-list");
const claerCompetedBtn = document.getElementById(`clear-completed-btn`);
const todoInput = document.getElementById("todo-input");
const filterBtns = document.querySelectorAll('.filter-buttons button');

// =======초기화 함수 ===============================================
// 웹이 시작될 때 실행되는 기본함수
//이벤트 등록 화면 렌더링을 담당

function init(){
   bindEvents();
   render();
}

function bindEvents(){
    const addBtn = document.getElementById('todo-add-btn');
    addBtn.addEventListener('click', addTodo);
    todoInput.addEventListener("keydown", function(e){
        if(e.key ==='Enter'){
            addTodo();
        }
    })
    claerCompetedBtn.addEventListener('click',claerCompetedTodos)
    
    
    
    //필터버튼가져와서 이벤트를 등록
    
    filterBtns.forEach(function(btn){
          btn.addEventListener('click', function(ev){
            
            setFilter(ev.target.dataset.filter);
          })
    })
}


//================ 데이터 조작 함수 ===================================================
//새로운 할일을 추가하는 함수

//할일목록을 저장하는 것
function saveTodos(){
    localStorage.setItem('todos',JSON.stringify(todos));
}

function claerCompetedTodos(){
   let newTodos = [];
   
   for(let todo of todos){
        
        if(!todo.completed){
         newTodos.push(todo);
        }
    }
    todos = newTodos;
    saveTodos();
    render();
}

function addTodo(){
   

   const text = todoInput.value.trim();
   if(!text) return; //빈문자열이면 함수 종료 
   
   const todo = {
    id : Date.now() , //현재시간을 ms단위로 변환 -> 고유한 아이디로 사용
    content : text,
    completed : false,
    createdAt: new Date().toLocaleDateString(),//생성시간
   }

 todos.push(todo);
 todoInput.value="";
  
 saveTodos();

 render();
 //할일목록을 기준으로 UI에 적용
}

function deleteTodo(id){
    //해당 ID를 목록에서 제거.
    let newTodo = [];
    for(let todo of todos){
        if(todo.id === id)
            continue;

        newTodo.push(todo);
    }

    todos = newTodo;
    saveTodos();
    render(); //할일목록을 기준으로 UI에 적용
}


function toggleTodo(id){
   //해당id를 통해서 할일을 찾아 완료상태 - > 미완료 미완 ->완료
    for(let todo of todos){
        
        if(todo.id === id){
           todo.completed = !todo.completed; 
           saveTodos();
           render();
           return;
        }
            
         
    }

}
//========== 화면 렌더링을 위한 함수 ==============
//메인 랜더링 함수 
function render() {
    todoList.innerHTML = ""; //기존 UI 제거
    
    const filteredTodos = getFilteredTodos();
   

     if (filteredTodos.length === 0) { //할일목록이 비어있다면
        emptyStateRender();
    } else { //할일 목록이 있는 경우
        filteredTodos.forEach(function (todo) {
            todoItemRender(todo);
        })
    }

    updateCount();
    updateClearButton();
}

function emptyStateRender(){

     const emptyEl = document.createElement('div');
    emptyEl.className= 'empty-state';
    emptyEl.innerHTML= "할 일이 없습니다"
    todoList.appendChild(emptyEl);
}

function todoItemRender(todo){
      const todoItem = document.createElement('li');
       todoItem.className='todo-item' + (todo.completed ? ' completed' : '');
    
       todoItem.innerHTML = 
       `<div class="todo-checkbox ${todo.completed ? 'checked' : ''}"></div>
        <span>${todo.content}</span>
        <button class="delete-btn">삭제</button>`;
       

      //새로 생성된 요소들 중에서이벤트가 필요한 부분만 가져오기.
      const checkBox =  todoItem.querySelector('.todo-checkbox');//todoItem내부에 있는 요소 가져옴
      
      checkBox.addEventListener('click',function(){
          toggleTodo(todo.id);
      })
      
      const deleteBtn = todoItem.querySelector(".delete-btn");               
    
      deleteBtn.addEventListener('click', function(){
        
        deleteTodo(todo.id);
      })

     todoList.appendChild(todoItem);
}

function updateCount(){
    const todoCount = document.getElementById('todo-count');
    let count = 0;
    for(let todo of todos){
      if(!todo.completed) count++;


    } 
   
    todoCount.innerHTML=`${count}개 남음`;
}

function updateClearButton(){
    let isView = 'none';
        for(let todo of todos){
      if(todo.completed){ 
        isView = 'block';
         break;
      }
     
    } 
   
   claerCompetedBtn.style.display = isView;
}
//================필터관련 함수==============================
//필터를 설정하고 UI를 업데이트
function setFilter(filter){
   filterState = filter; //전역상태에필터상태를 변경
   //모든 필터버튼의 active클래스를 조회해서 순회

   filterBtns.forEach(function(btn){
    btn.className = (btn.dataset.filter===filter ? "active" : "" );
   })
   render();
}

//현재 필터에 따라서 할일이 정해짐 
function getFilteredTodos(){
    const filteredTodos = [];
    if(filterState === 'active'){
        //미완료목록만 filteredTodos에 담김
        for(let todo of todos){
            if(!todo.completed){
                filteredTodos.push(todo);
            }
        }
    } else if(filterState === 'completed'){
        //완료목록만 filteredTodos에 담김
        for(let todo of todos){
            if(todo.completed){
                filteredTodos.push(todo);
            }
        }
    } else{
        return todos;
    }

    return filteredTodos;
}



//============= load 이벤트 함수 =====================================================
// window.onload = function(){
//     init();
// }

//DOMContentLoaded ->HTML이 전부 로드되어 DOM트리가 완성되면 실행
document.addEventListener('DOMContentLoaded', init);










