import Search from "../components/Search";
import styled from "styled-components";
import Logo from "../components/Logo";

export default function () {
  const Wrapper = styled.div`
    margin: 100px 0px;
  `;
  return (
    <Wrapper>
      <Logo />
      <Search />
    </Wrapper>
  );
}
