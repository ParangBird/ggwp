import {useState} from "react";
import axios from "axios";

export default function(){

    const [inputId, setInputId] = useState('')
    const [inputPw, setInputPw] = useState('')

    const Login = () => {
        axios.post('/register', null,
            {
                params : {
                    userName : inputId,
                    password : inputPw,
                    email : '.com'} })
            .then((res) => {
                console.log('등록 성공')
            }).catch((err) => {
                console.error(err)
            }
        )
    }

    const onIdChange = (e) => {
        setInputId(e.target.value)
    }
    const onPwChange = (e) => {
        setInputPw(e.target.value)
    }


    return(
        <>
            <h2>회원가입창</h2>
        </>
    )
}