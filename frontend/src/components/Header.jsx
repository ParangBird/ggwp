import styled from "styled-components";
import { Navbar, Container, Nav } from "react-bootstrap";
import SearchSmall from "./SearchSmall";
import Logo from "./Logo";
import LoginForm from "./login/LoginForm";

const Topbar = styled(Navbar)`
  background-color: black;
  height: 150px;
`;

const HeaderContainer = styled(Container)`
  max-width: 1000px;
`;

export default function Header() {
  return (
    <div>
      <Topbar variant="dark">
        <HeaderContainer>
          <Navbar.Brand href="/">
            <Logo />
          </Navbar.Brand>
          <Nav>
            <SearchSmall />
          </Nav>
        </HeaderContainer>
        <LoginForm />
      </Topbar>

      <Navbar bg="dark" variant="dark">
        <HeaderContainer>
          <Nav>
            <Nav.Link href="#">챔피언 정보</Nav.Link>
            <Nav.Link href="/ranking">랭킹</Nav.Link>
            <Nav.Link href="/multi">멀티서치</Nav.Link>
            <Nav.Link href="http://localhost:8080/bbs">커뮤니티</Nav.Link>
          </Nav>
        </HeaderContainer>
      </Navbar>
    </div>
  );
}
