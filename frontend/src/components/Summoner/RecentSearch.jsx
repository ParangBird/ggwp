import LocalSave from "./LocalSave";
import styled from "styled-components";
import { useState, useLayoutEffect } from "react";

const RecentSearchDiv = styled.div`
  width: 550px;
  margin: auto;
  background-color: white;
  display: block;
  position: absolute;
  z-index: 100;
`;

export default function ({ visible, width, icon }) {
  const [localSave, setLocalSave] = useState([]);

  useLayoutEffect(() => {
    let newLocal = [];
    let length = localStorage.length;
    if (length > 7) length = 7;

    for (let i = length - 1; i >= 0; i--) {
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

  const mouseDownHandler = (e) => {
    e.preventDefault();
  };

  const removeHandler = (e, name) => {
    e.preventDefault();
    const newLocal = localSave.filter((save) => save.name !== name);
    setLocalSave(newLocal);
  };

  return (
    <>
      {visible && (
        <RecentSearchDiv style={{ width: `${width}` }} onMouseDown={mouseDownHandler}>
          {localSave.map((ls) => (
            <LocalSave key={ls.name} ls={ls} removeHandler={removeHandler} icon={icon} />
          ))}
        </RecentSearchDiv>
      )}
    </>
  );
}
