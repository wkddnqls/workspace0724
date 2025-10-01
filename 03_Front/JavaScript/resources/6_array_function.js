//자료형,목적에따라 가장 간결하고 명확하게 구현하기 위한 다양한 반복문이 존재.
//읽기/변환/필터링/검색.... 목저게 맞는 반복문을 골라 사용해야 가독성 높아짐.



let members =[ 
 "최지원",
 "김지원",
 "이지원",
 "박지원",
 "정지원",
 "황지원",]


 console.log(members.push("신지원"));
 console.log(members);

 //splice(인덱스, 몇개) -> 원본에서 특정 인덱스부터 n개를 잘라냄.
 console.log(members.splice(1,3));
 console.log(members);

 //slice(인덱스, 마지막 인덱스 - 1) -> 원본에서 특정 인덱스부터 마지막인덱스 -1 개 추출.
 console.log(members.slice(0,3));
 console.log(members);


let members1 =[ 
 "최지원",
 "김지원",
 "이지원",
 "박지원",
 "정지원",
 "황지원",]


 //....배열 또는 ...객체 -> spread연산자
 //배열이나 객체의 요소를 개별적으로 펼쳐서 복사하거나 전달할떄 사용

let members2=[
    ...members1,
    "신지원"
]

console.log(members2)

let choi ={
    name:"jiwon",
    age: 24,
    gender:'남'
};
console.log(choi);
//값 수정
choi ={
    ...choi,
    gender:'여'
};

console.log(choi);

//데이터를 추가할 때
choi= {
  ...choi,
  address:"경기도 광명시 "
}

console.log(choi);

/**
 * 비구조 할당
 * 배열이나 객체에서 값을 추출할 때 개별변수에 할당해서 추출하는 문법
 */
 members = [
    "최지원",
    "김지원",
    "이지원"
 ];

 //const cho = members[0];
 //const kim = members[1];
 //const lee = members[2];

 const[cho,kim,lee] =members;
 
 console.log(cho,kim,lee);

choi ={
    name:"jiwon",
    age: 24,
    gender:'남'
};
 
const{name , age} = choi;
console.log(name);

console.log(age);

//const userName = choi.name;
//const userage = choi.age;

const {name:userName , age:userAge} = choi;
console.log(userName);

console.log(userAge);

//join(구분자) -> 배열을 문자열로 변경해줌
console.log(members);
console.log(members.join("/"));

//reverse() -> 배열을 지금상태에서 역순으로 정렬

console.log(members2);
members2.reverse(); //역순으로 ;
console.log(members2);



//sort()
console.log(members2);
members2.sort(); //오름차순 정렬
console.log(members2);
members2.sort().reverse(); //내림차순 ;

 stdList = [
        {name: '최지원', java : 75 , db : 30 , front: 30 },
        {name: '최지투', java : 65 , db : 40 , front: 40 },
        {name: '최지삼', java : 55 , db : 50 , front: 50 },
        {name: '최지사', java : 45 , db : 60 , front: 60 },
        {name: '최지오', java : 35 , db : 70 , front: 70 },
        {name: '장진우', java : 75 , db : 70 , front: 90 },
       ]

       /**
        * 정렬기준이 없을 떄는 직접 콜백함수를 통해 정렬기준을 전달할 수 있음
        * a,b를 비교
        * 1) a를b보다 나중에 정렬하고싶다면(뒤에두고 싶다면) 0보다 큰수를 반환.
        * 2) a를b보다 먼저 정렬하고싶다면(앞에두고 싶다면 ) 0보다 작은수를 반환.
        * 3) 원래순서를 유지하고싶다면 0을 반환
        */
stdList.sort(function(a,b){
    return a.name >b.name ? 1:-1 //오름차순
})

console.log(stdList);



//js 반복문

stdList = [
        {name: '최지원', java : 75 , db : 30 , front: 30 },
        {name: '최지투', java : 65 , db : 40 , front: 40 },
        {name: '최지삼', java : 55 , db : 50 , front: 50 },
        {name: '최지사', java : 45 , db : 60 , front: 60 },
        {name: '최지오', java : 35 , db : 70 , front: 70 },
        {name: '장진우', java : 75 , db : 70 , front: 90 },
       ]


for(let i=0 ; i<stdList.length ;i++){
    console.log(stdList[i]);
}

//for..of
//배열 값 중심으로 순회한다. 가장깔끔하며 인덱스가 필요없을 때 사용.
console.log("==================for..of========================")
for(const std of stdList){
    console.log(std);
}

//for..in
//인덱스 중심으로 순회한다.
console.log("==================for..in========================")
for(const i in stdList){
    console.log(i + "번쨰 : ", stdList[i]);
}

//객체에 사용시 key를 전부 열거할 수 있음.
const std = {name : "최지원" , java : 75 , db: 80 , front : 90};
for(const key in std){
    console.log(key);
}

//---------배열의 고지 함수 -------------------
//읽기전용 + 새로운배열/값을 반환 -> 불변경 유지를 위해 
//배열/객체.forEach(function(v:순차적으로 요소 하나,i: 인덱스 ,a: 전체 배열의 요소))
console.log("====================================================================")
stdList.forEach(function(v,i,a){
    console.log(v," ??????????",i ," ????????",a);
});






