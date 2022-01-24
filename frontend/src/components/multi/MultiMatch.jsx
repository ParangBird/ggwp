import styled from "styled-components";
import { getChampImgUrl } from "../common/imgSource";
import { getKDA, getTimeHasBeen } from "../common/cal";

const SummonerDiv = styled.div`
  display: block;
  text-align: left;
  width: 300px;
  height: 26px;
  line-height: 26px;
  margin: 1px;
  background-color: ${(props) => {
    if (props.win) {
      return "#d0e4ff";
    } else {
      return "#FFEEEE";
    }
  }};
  border: ${(props) => {
    if (props.win) {
      return "1px solid #a1b5d1";
    } else {
      return "1px solid #ddb7b7";
    }
  }};
`;

const ChampionImg = styled.div`
  background-image: url(${(props) => props.img});
  background-size: cover;
  display: inline-block;
  margin-right: 5px;
  width: 24px;
  height: 24px;
`;

const Text = styled.span`
  width: ${(props) => props.width};
  display: inline-block;
  vertical-align: top;
  text-align: center;
  text-align: center;
  font-size: 10pt;
`;

export default function ({ match }) {
  return (
    <>
      <SummonerDiv win={match.win}>
        <ChampionImg img={getChampImgUrl(match.champ)}></ChampionImg>
        <Text width={"146px"}>
          <span style={{ marginRight: "5px" }}>
            {match.kills + " "}/{" " + match.deaths + " "}/{" " + match.assists}
          </span>
        </Text>
        <Text width={"70px"}>
          <span style={{ marginRight: "5px" }}>{getKDA(match.kills, match.deaths, match.assists)}</span>
        </Text>
        <Text width={"50px"}>
          <span>{getTimeHasBeen(match.gameEndTimestamp)}</span>
        </Text>
      </SummonerDiv>
    </>
  );
}
