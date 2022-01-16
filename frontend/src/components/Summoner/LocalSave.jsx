import React from "react";
import styled from "styled-components";
import { AiOutlineClose } from "react-icons/ai";
import { Link } from "react-router-dom";

const Img = styled.img`
  width: 50px;
  border-radius: 50px;
  margin: 10px 20px;
`;

const Button = styled.button`
  background-color: white;
  color: grey;
  float: right;
  border: 0px;
  margin: 0px 5px;
`;

const Div = styled.div`
  position: relative;
  float: left;
  width: 50%;
  text-align: left;
  padding: 5px;
`;

export default function LocalSave(props) {
  const { ls, removeHandler } = props;

  const onRemove = (e) => {
    e.preventDefault();

    localStorage.removeItem(ls.name);
    removeHandler(e, ls.name);
  };

  return (
    <Div>
      {props.icon && <Img src={ls.url} alt={ls.name} />}
      <Link to={`/search/${ls.name}`} style={{ textDecoration: "none", color: "black" }}>
        <span>{ls.name}</span>
      </Link>
      <Button onClick={onRemove}>
        <AiOutlineClose />
      </Button>
    </Div>
  );
}
