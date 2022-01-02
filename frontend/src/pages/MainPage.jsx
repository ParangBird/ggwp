import Search from "../components/Search";
import styled from "styled-components";
import Logo from "../components/Logo";

const Wrapper = styled.div`
  margin: 100px 0px;
`;

export default function () {
  return (
    <Wrapper>
      <Logo />
      <Search />
    </Wrapper>
  );
}
