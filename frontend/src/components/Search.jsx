import styled from "styled-components";
import React, { useState } from "react";
import { Link } from "react-router-dom";

const Form = styled.form`
  text-align: right;
  margin: 30px auto;
  background-color: white;
  width: 550px;
`;

const SearchBar = styled.input`
  padding: 15px 150px 18px 17px;
  background-color: white;
  font-weight: 400;
  width: 500px;
  border: 0px;
  border-radius: 3px;
`;

const SearchButton = styled.button`
  position: relative;
  right: 0px;
  background-color: #30383e;
  color: white;
  font-size: 15px;
  font-weight: 600;
  cursor: pointer;
  height: 55px;
  width: 50px;
  border: 0px;
  border-radius: 3px;
`;

export default function Search() {
  const [name, setName] = useState("");

  const nameChange = (e) => {
    setName(e.target.value);
  };

  return (
    <Form>
      <SearchBar onChange={nameChange} type="text" placeholder="소환사명"></SearchBar>
      <Link to={`/search/${name}`}>
        <SearchButton>검색</SearchButton>
      </Link>
    </Form>
  );
}
