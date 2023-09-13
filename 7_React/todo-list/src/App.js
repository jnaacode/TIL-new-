import React, { useState, createContext } from 'react';
import './App.css';

import SignupContainer from './Signup';
import Login from './Login';
import Test from './test';
import TodoList from './TodoList';

export const TodoListContext = createContext(); // 전역변수생성 (내보낼 수 있는)


function App() {
  // 회원가입, 로그인, 회원의 Todo List 출력/추가/제거
  const [signupView, setSignupView] = useState(false);

  // 로그인한 회원정보 저장
  const [loginMember, setLoginMember] = useState(null);

  // 로그인한 회원의 todo-list를 저장 
  const [todoList, setTodoList] = useState([]);




  return (
    <TodoListContext.Provider value={{setTodoList,setLoginMember,loginMember,todoList}}>
                      {/* 버튼을 클릭할때마다 signupView가 true변했다가 */}
      <button onClick={ () => {setSignupView(!signupView)} }>
        { signupView ? ('회원 가입 닫기') : ('회원 가입 열기')}
      </button>

      <div className='signup-wrapper'>
        {/* signupView가 true인 경우에만 회원 가입 컴포넌트 렌더링 */}
        {/* 조건식 && (true인 경우) */}
        {signupView === true && (<SignupContainer/>)}
      </div>
      
      <h1>Todo List</h1>
      <Login/>

      <hr/>

      <>
      {/* 로그인 되었을때만 TodoList 출력 */}
      {loginMember && (<TodoList/>)}
      </>


      
     

    </TodoListContext.Provider>
    
  );
}

export default App;