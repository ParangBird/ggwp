import styled from "styled-components";
import { Navbar, Container, Nav } from "react-bootstrap";
import SearchSmall from "./SearchSmall";
import Logo from "./Logo";

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
      </Topbar>

      <Navbar bg="dark" variant="dark">
        <HeaderContainer>
          <Nav>
            <Nav.Link href="#">챔피언 정보</Nav.Link>
            <Nav.Link href="/ranking">랭킹</Nav.Link>
            <Nav.Link href="#">멀티서치</Nav.Link>
            <Nav.Link href="#">커뮤니티</Nav.Link>
            <Nav.Link href="/register">회원가입</Nav.Link>
          </Nav>
        </HeaderContainer>
      </Navbar>
    </div>
  );
}
