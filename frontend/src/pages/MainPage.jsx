import Search from "../components/Search";
import styled from "styled-components";
import Logo from "../components/Logo";
import LocalSave from "../components/Summoner/LocalSave";
import { useState, useLayoutEffect } from "react";

const Wrapper = styled.div`
  margin: 100px 0px;
`;

export default function () {
  const [localSave, setLocalSave] = useState([]);

  useLayoutEffect(() => {
    let newLocal = [];
    for (let i = localStorage.length - 1; i >= 0; i--) {
      newLocal = newLocal.concat(JSON.parse(localStorage.getItem(localStorage.key(i))));
    }

    newLocal.sort((a, b) => {
      if (a.time > b.time) {
        return -1;
      } else if (a.time < b.time) {
        return 1;
      } else {
        return 0;
      }
    });
    setLocalSave(newLocal);
  }, []);

  const removeHandler = (e, name) => {
    e.preventDefault();
    const newLocal = localSave.filter((save) => save.name !== name);
    setLocalSave(newLocal);
  };

  return (
    <Wrapper>
      <Logo />
      {localSave.map((ls) => (
        <LocalSave key={ls.name} ls={ls} removeHandler={removeHandler} />
      ))}
      <Search />
    </Wrapper>
  );
}
