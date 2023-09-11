import React, { useState } from 'react';

const SignupContainer = () => {

    const[id,setId] = useState('');
    const[pw,setPw] = useState('');
    const[pwCheck,setPwCheck] = useState('');
    const[name,setname] = useState('');
    const[result,setResult] = useState('');


    //회원가입 함수
    const signup=() => {
        //1. 비밀번호가 일치하지 않으면 (pw !== pwCheck)
        //   '비밀번호가 일치하지 않습니다' alert로 출력 후 return     
            if(pw !== pwCheck){
                alert("비밀번호가 일치하지 않습니다.")
                return;
            }

            // *** 회원가입 요청(비동기)
            fetch("/signup",{
                method:"POST",
                headers : {
                    "Content-Type" : "application/json"
                },
                //JS Object -> JSON
                body:JSON.stringify({
                    id :id,
                    pw : pw,
                    name :name

                })
            })
            .then(resp => resp.text())
            .then(result => {

                
        // result > 0 다면
        //    result에 '회원 가입 성공' 출력
        //    + 모든 입력칸(input) 내용삭제

            if(result>0){
                setResult("회원가입성공")
                setId("")
                setPw("")
                setPwCheck("")
                setname("")
             
             }else{
                 //  아니면 result에 '회원가입실패' 출력
                 setResult("회원가입실패")
             }
 

            })
            .catch(e => console.log(e));




      
    }
    return(
        <div className='signup-container'>
            <label>
                ID : 
                <input type='text' onChange={e=>{setId(e.target.value)}}
                value={id}/>
            </label>

            <label>
                PW : 
                <input type='password' onChange={e=>{setPw(e.target.value)}}
                value={pw}/>
            </label>

            <label>
                PW CHECK : 
                <input type='password' onChange={e=>{setPwCheck(e.target.value)}}
                value={pwCheck}/>
            </label>

            <label>
                NAME : 
                <input type='text' onChange={e=>{setname(e.target.value)}}
                value={name}/>
            </label>

            <button onClick={signup}>가입하기</button>

            <hr/>

            <h3>{result}</h3>



        </div>
    )



};

export default SignupContainer;

