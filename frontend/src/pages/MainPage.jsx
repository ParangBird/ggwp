import Search from "../components/Search";
import styled from "styled-components";
import Logo from "../components/Logo";
import LocalSave from "../components/Summoner/LocalSave";
import { useState, useLayoutEffect } from "react";

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
