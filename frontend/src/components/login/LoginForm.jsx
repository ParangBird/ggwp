import styled from "styled-components";
import { FaLock, FaUserAlt } from "react-icons/fa";
import { Link } from "react-router-dom";
import {useState} from "react";

const RegisterFormDiv = styled.div`
  background-color: #f4f4f4;
  width: 320px;
  padding: 10px 0 10px 0;
  margin-right: 20px;
`;

const LoginText = styled.span`
  display: block;
  margin-bottom: 10px;
  color: grey;
`;

const LogoutButton = styled.button`
  background-color: grey;
  display: block;
  width: 80%;
  font-size: 30px;
  margin: 5px auto;
  color: white;
  border: 0;
`;

const LoginButton = styled.button`
  background-color: grey;
  display: block;
  width: 80%;
  font-size: 30px;
  margin: 5px auto;
  color: white;
  border: 0;
`;

const FindLink = styled.span`
  &:hover {
    color: black;
    text-decoration: underline;
  }
  color: black;
  display: inline;
  margin-right: 30px;
  text-decoration-line: none;
`;

const RegisterLink = styled.span`
  text-decoration-line: none;
  &:hover {
    color: black;
    text-decoration: underline;
  }
  color: black;
`;

export default function LoginForm() {
    const [logIn, setLogIn] = useState(true)
    const user = window.sessionStorage.getItem('user');
    const logout = () => {
        window.sessionStorage.removeItem('user');
        setLogIn(false)
        console.log(logIn);
    }
  return (
    <RegisterFormDiv>
        <>
            {
                user ?
                    <>
                        <LoginText>환영합니다, {user} 님!</LoginText>
                        <LogoutButton onClick = {logout}>GG.WP 로그아웃</LogoutButton>
                    </>:
                <>
                    <LoginText>GG.WP를 더 편리하게 이용하세요</LoginText>
                    <Link to="login" style={{textDecoration: "none"}}>
                        <LoginButton>GG.WP 로그인</LoginButton>
                    </Link>
                    <FaLock />
                    <Link to="find" style={{ textDecoration: "none" }}>
                        <FindLink>아이디ㆍ비밀번호 찾기</FindLink>
                    </Link>
                    <FaUserAlt />
                    <Link to="register" style={{ textDecoration: "none" }}>
                        <RegisterLink>회원가입</RegisterLink>
                    </Link>
                </>
            }
        </>

    </RegisterFormDiv>
  );
}
