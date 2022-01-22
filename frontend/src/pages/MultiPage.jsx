import styled from "styled-components";
import { useState } from "react";
import { Button } from "react-bootstrap";
import MultiSummoner from "../components/multi/MultiSummoner";

const MultiSearchDiv = styled.div`
  margin: auto;
  width: 700px;
`;

const MultiSearch = styled.textarea`
  width: 700px;
  height: 170px;
  border: 1px solid #6c757d;
  margin: 10px 0px 10px 0px;
  resize: none;
  line-height: 1.22;
`;

export default function () {
  const [nameString, setNameString] = useState("");
  const [names, setNames] = useState([]);

  const nameChange = (e) => {
    setNameString(e.target.value);
  };

  const buttonClick = () => {
    setNames(nameString.split("님이 로비에 참가하셨습니다.\n"));
    console.log(nameString);
    console.log(names);
  };

  return (
    <>
      <MultiSearchDiv>
        <MultiSearch type="textarea" onChange={nameChange} onBlur={nameChange} />
        <Button onClick={buttonClick} style={{ width: "600px" }} variant="outline-secondary">
          동시에 검색하기
        </Button>
      </MultiSearchDiv>
      {names.map((name) => (
        <MultiSummoner myName={name} />
      ))}
    </>
  );
}
