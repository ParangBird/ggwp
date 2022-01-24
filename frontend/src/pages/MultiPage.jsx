import styled from "styled-components";
import { useEffect, useState } from "react";
import { Button } from "react-bootstrap";
import { multiStr } from "../components/common/cal";
import MultiSummoner from "../components/multi/MultiSummoner";
import { useParams } from "react-router-dom";

const MultiSearchDiv = styled.div`
  margin: 20px auto;
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

const InfoDiv = styled.div`
  margin: 20px auto;
  width: 600px;
`;

export default function () {
  const [nameString, setNameString] = useState(useParams().name);
  const [names, setNames] = useState([]);
  const [infoDisplay, setInfoDisplay] = useState("");

  useEffect(() => {
    if (nameString) {
      setNames(multiStr(nameString));
      setInfoDisplay("none");
    }
  }, []);

  const nameChange = (e) => {
    setNameString(e.target.value);
  };

  const buttonClick = () => {
    if (nameString == "") return;
    setNames(multiStr(nameString));
    setInfoDisplay("none");
  };

  return (
    <>
      <MultiSearchDiv>
        <MultiSearch type="textarea" onChange={nameChange} onBlur={nameChange} value={nameString} />
        <Button onClick={buttonClick} style={{ width: "600px" }} variant="outline-secondary">
          동시에 검색하기
        </Button>
      </MultiSearchDiv>
      <InfoDiv style={{ display: infoDisplay }}>
        <h3>멀티서치</h3>
        <h5>채팅창의 팀원정보를 아래처럼 붙여넣기하여 한눈에 파악하세요!</h5>
        <div style={{ textAlign: "left" }}>
          <br />
          <h6>예시 1)</h6>
          <br />
          신은 어딨을까님이 로비에 참가하셨습니다.
          <br />
          난집게리아가아냐님이 로비에 참가하셨습니다.
          <br />
          돈까스치즈퐁당님이 로비에 참가하셨습니다.
          <br />
          hide on bush님이 로비에 참가하셨습니다.
          <br />
          은가뉴님이 로비에 참가하셨습니다.
          <br />
          <br />
          <h6>예시 2)</h6>
          <br />
          신은 어딨을까,난집게리아가아냐,돈까스치즈퐁당,hide on bush,은가뉴
        </div>
      </InfoDiv>
      {names.map((name) => (
        <MultiSummoner myName={name} />
      ))}
    </>
  );
}
