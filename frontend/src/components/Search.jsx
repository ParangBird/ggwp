import styled from "styled-components";
import React, { useState } from "react";
import { Link } from "react-router-dom";
import RecentSearch from "./Summoner/RecentSearch";

const Form = styled.form`
  text-align: right;
  margin: 30px auto 0px auto;
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
  outline: none;
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
  const [visible, setVisible] = useState(false);

  const nameChange = (e) => {
    setName(e.target.value);
  };

  const inputClick = () => {
    setVisible(!visible);
  };

  return (
    <>
      <Form>
        <SearchBar onFocus={inputClick} onBlur={inputClick} onChange={nameChange} type="text" placeholder="소환사명" />
        <Link to={`/search/${name}`}>
          <SearchButton>검색</SearchButton>
        </Link>
        <RecentSearch visible={visible} icon={true} />
      </Form>
    </>
  );
}
