import styled from "styled-components"
import axios from "axios";
import {useState} from "react";

const LoginDiv = styled.div`
  background-color : #F0F0F0;
  margin : 30px auto 0 auto;
  width : 30vw;
  height : 70vh;
`;

const IdInput = styled.input`
  display : block;
  margin : 0 auto;
  margin-top : 30px;
  width : 60%;
`

const PwInput = styled.input`
  display : block;
  margin : 0 auto;
  margin-top : 30px;
  width : 60%;
`

const LoginButton = styled.button`
  margin-top : 30px;
`
export default function(){

    const [inputId, setInputId] = useState('')
    const [inputPw, setInputPw] = useState('')

    const onIdChange = (e) => {
        setInputId(e.target.value)
    }
    const onPwChange = (e) => {
        setInputPw(e.target.value)
    }

    const Login = () => {
        axios.get('/api/login', {params : {
                username : inputId,
                password : inputPw
            }})
            .then((res) => {
                if(res.data === 'SUCCESS'){
                    console.log('로그인 성공')
                }
                else if(res.data === 'FAIL'){
                    console.log('로그인 실패')
                }
            }
            ).catch((err) => {console.error(err)})
    }

    return(
        <LoginDiv>
            <h2>GG.WP</h2>
            <IdInput name="userid" placeholder="아이디" onChange = {onIdChange} />
            <PwInput name="password" placeholder="비밀번호" onChange = {onPwChange} />
            <LoginButton onClick = {Login}>로그인</LoginButton>
            <hr/>
            <h3>간편 로그인</h3>
            <h3>뭐</h3>
            <h3>여러</h3>
            <h3>가지가</h3>
            <h3>있겠죠</h3>
        </LoginDiv>
    )
}