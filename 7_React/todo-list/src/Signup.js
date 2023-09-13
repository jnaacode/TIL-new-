import React, { useState } from 'react';

const SignupContainer = () => {

    const[id,setId] = useState('');
    const[pw,setPw] = useState('');
    const[pwCheck,setPwCheck] = useState('');
    const[name,setname] = useState('');
    const[result,setResult] = useState('');

    // 아이디 중복 검사 -> false 사용 불가 / true 사용가능 (임의지정)
    const [idValidation,setIdValidation] = useState(false);

    const idCheck = (inputId) => {
        // inputId : 입력한 아디이
        setId(inputId ) // id변수에 입력받은 아이디 대입
        
        // 4글자 미만 검사 x (아래 함수 실행하지 않겠다.)
        if(inputId.trim().length<4){
            setIdValidation(false)
            return;
         }
         fetch("/idCheck?id=" +inputId)
         .then( resp => resp.text())
         .then( result => {

            console.log(`result:${result}`)//`` 문자열 + 안써도 된다! 
            console.log(typeof result)//`` 문자열 + 안써도 된다! 

            // number타입으로 parsing
            if(Number(result)===0){ // 중복이 X -> 사용 o
                setIdValidation(true)
            }else{ // 중복 o -> 사용 X
                setIdValidation(false)
            }

         })
         .catch(e=>console.log(e))
    }


    //회원가입 함수
    const signup=() => {

        // 아이디가 사용 불가인 경우 (4이하거나 중복)
        if(!idValidation){
            alert("아이디를 다시 입력해주세요.")
            return;
        }



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
                <input type='text' onChange={e=>{
                    //setId(e.target.value)
                    idCheck(e.target.value)
                }}
                value={id}
                className={idValidation? '' :"id-error"}
                />
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

