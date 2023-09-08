import React, { useEffect, useState } from "react";

/* 컴포넌트 이름은 대문자! */
const Id = ({ handler }) => {

    // props로 전달한 값 Key가 handler인 요소의 value 반환
     console.log(handler)


    return (

        <>
            <div className="wrapper">
                <label htmlFor="id"> ID : </label>
                <input type="text" id="id" onChange={handler} />
            </div>
        </>

    );
};

const Pw = ({ handler }) => {

    return (

        <>
            <div className="wrapper">
                <label htmlFor="pw"> PW : </label>
                <input type="password" id="pw" onChange={handler}></input>
            </div>
        </>

    );
};

// 상태 끌어올리기 
const StateLiftingUp = () => {

    const [id, setId] = useState('');
    const [pw, setPw] = useState('');

    const idHandler = (e) => { // id값 변경 함수

        /* 아이디 값 변경 함수 */
        setId(e.target.value);

    }

    const PwHandler = (e) => { // id값 변경 함수

        /* 비밀번호 값 변경 함수 */
        setPw(e.target.value);

    }

    console.log("id:" + id);
    console.log("w:" + pw);


    return (
        <>
            <Id handler={idHandler} />
            <Pw handler={PwHandler} />

            <div className="wrapper">
                <button disabled={id.length === 0 || pw.length === 0}>Login</button>
            </div>

        </>
    );


}

export default StateLiftingUp;