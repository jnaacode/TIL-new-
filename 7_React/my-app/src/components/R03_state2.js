import React,{useState} from "react";

const State2 = (props) =>{

    // props: 부모로부터 전달 받은 값을 저장한 객체 
    // props.init

    // 기본 형태 : const[변수, 값을 변경할 함수(setter)] = useState(초기값);
    // useState : 컴포넌트의 상태를 관리 할 때 사용하는 Hook
    //const [count,setCount] = useState(0);
    const [count,setCount] = useState(props.init);
 
    return(
        <div>
            <h3>{count}</h3>
            <button onClick={()=>setCount(count+1)}>클릭하면 Count1증가</button>
        </div>
    );
}
export default State2;