import React from "react";
import styled from "styled-components";
import { Link } from "react-router-dom";

const Img = styled.img`
  width: 50px;
  border-radius: 50px;
`;

function LocalSave(props) {
  const { ls, removeHandler } = props;

  const onRemove = (e) => {
    e.preventDefault();

    localStorage.removeItem(ls.name);
    removeHandler(e, ls.name);
  };

  return (
    <div>
      <Img src={ls.profileIconUrl} alt={ls.name} />
      <span>{ls.name}</span>
      <button onClick={onRemove}>x</button>
    </div>
  );
}

export default LocalSave;
