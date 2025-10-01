////전역 상태 변수 들 ///

let todos = JSON.parse(localStorage.getItem('todos')) || [];
let filterState = 'all';
let totalIncome = 0;
let totalExpense = 0;
const content = document.getElementById("content");
const amount = document.getElementById("amount");
const ShowList = document.getElementById('show-list');
const incomeBtn = document.getElementById('typeIncome');
const filterBtns = document.querySelectorAll('.filter-buttons button');
const typeBtns = document.querySelectorAll('#type-buttons button');
///////////////////////////////////////////////////////////
//초기화
document.addEventListener('DOMContentLoaded', init);

function init() {
  bindEvents();
  render();
}

function saveTodos() {
  localStorage.setItem("todos", JSON.stringify(todos));
}

/////////////////////////////////////////////////////////////
//랜더링
function render() {

  ShowList.innerHTML = "";
  totalIncome = 0;
  totalExpense = 0;

  const filteredTodos = getFilteredTodos();

  filteredTodos.forEach(function (todo) {
    TextInputAdd(todo);
  })


  for (let todo of todos) {

    if (todo.type === 'income') {
      totalIncome += todo.amount;
    } else if (todo.type === 'expense') {
      totalExpense += todo.amount;
    }
  }

  updateSummary()


}

///////////////////////////////////////////////////////////
//이벤트 바인딩
function bindEvents() {
  const addBtn = document.getElementById('addBtn');
  addBtn.addEventListener('click', TextInput);

  amount.addEventListener("keydown", function (e) {
    if (e.key === 'Enter') {
      TextInput();
    }
  })

  typeBtns.forEach(btn => {
    btn.addEventListener('click', function () {

      typeBtns.forEach(b => b.classList.remove('active'));


      btn.classList.add('active');
    });
  });

  filterBtns.forEach(function (btn) {
    btn.addEventListener('click', function (ev) {

      setFilter(ev.target.dataset.filter);
    })
  })

}

/////////////////////////////////////////////////////////////
// 합계 표시 
function updateSummary() {
  const balanceElement = document.getElementById('balance');
  const remainMoney = document.getElementById('remainmoney');
  const totalIncomeElement = document.getElementById('totalIncome');
  const totalExpenditureElement = document.getElementById('totalExpenditure');

  const balance = totalIncome - totalExpense;

  balanceElement.textContent = balance.toLocaleString() + "원";
  remainMoney.textContent = balance.toLocaleString() + "원";

  totalIncomeElement.textContent = "+" + totalIncome.toLocaleString() + "원";
  totalExpenditureElement.textContent = "-" + totalExpense.toLocaleString() + "원";

  if (balance > 0) {
    balanceElement.className = `green`
    remainMoney.className = `green`
  } else if (balance < 0) {
    balanceElement.className = `red`
    remainMoney.className = `red`
  }


}

///////////////////////////////////////////////////////////////
// 수입 지출쪽 기능들 입력 처리 기능들 \


function TextInput() {

  const text1 = content.value.trim();
  const text2 = amount.value.trim();

  if (!text1 || !text2) return;


  const type = incomeBtn.classList.contains('active') ? 'income' : 'expense';

  go = {
    id: Date.now(),
    description: text1,
    amount: parseInt(text2),
    type: type,
    date: new Date().toLocaleDateString()
  }

  todos.push(go);
  content.value = "";
  amount.value = "";

  saveTodos();
  render();


}

function TextInputAdd(go) {
  const InputAddHTML = document.createElement("div");
  InputAddHTML.className = 'transaction';

  const amountClass = go.type === 'income' ? 'plus' : 'minus';
  const amountSign = go.type === 'income' ? '+' : '-';

  InputAddHTML.innerHTML = `
    <div class="left">
      <span class="date">${go.date}</span>
      <span class="title">${go.description}</span>
    </div>
    <div class="right">
      <span class="amount ${amountClass}">${amountSign}${go.amount.toLocaleString()}원</span>
      <button class="delete-btn">삭제</button>
    </div>
  `;

  const deleteBtn = InputAddHTML.querySelector(".delete-btn");
  deleteBtn.addEventListener('click', function () {

    deletego(go.id);
  })


  ShowList.appendChild(InputAddHTML);

}


function deletego(id) {

  let newTodo = [];

  for (let todo of todos) {
    if (todo.id === id)
      continue;

    newTodo.push(todo);
  }

  todos = newTodo;
  saveTodos();
  render();
}


//////////////////////////////////////////////////////////////////////////////////////

////////////////////// 필터링 쪽 기능들

function setFilter(filter) {
  filterState = filter;

  filterBtns.forEach(function (btn) {
    btn.className = (btn.dataset.filter === filter ? "active" : "");
  })
  render();
}

function getFilteredTodos() {
  const filteredTodos = [];
  if (filterState === 'filter-income') {
    //미완료목록만 filteredTodos에 담김
    for (let todo of todos) {
      if (todo.type === 'income') {
        filteredTodos.push(todo);
      }
    }
  } else if (filterState === 'filter-expenditure') {
    //완료목록만 filteredTodos에 담김
    for (let todo of todos) {
      if (todo.type === 'expense') {
        filteredTodos.push(todo);
      }
    }
  } else {
    return todos;
  }

  return filteredTodos;
}
/////////////////////////////////////////////////////////////////