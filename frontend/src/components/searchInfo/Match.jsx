import { getGameType, winOrLose, getKDA } from "../common/cal";
import styled from "styled-components";

const ContentWrapper = styled.div`
  border: 1px solid #b5babf;
  background-color: ${(props) => {
    if (props.win) {
      return "#d0e4ff";
    } else {
      return "#FFEEEE";
    }
  }};
  display: table;
  width: 1000px;
  height: 100px;
`;

const MatchStats = styled.div`
  display: table-cell;
  vertical-align: middle;
  text-align: center;
  width: 70px;
`;

const KDA = styled.div`
  display: table-cell;
  vertical-align: middle;
  text-align: center;
  width: 90px;
`;

const ChampionImgBig = styled.div`
  background-image: url(${(props) => props.img});
  background-size: cover;
  margin-left: 10px;
  width: 50px;
  height: 50px;
`;

const ChampionImgSmall = styled.div`
  background-image: url(${(props) => props.img});
  background-size: cover;
  width: 20px;
  height: 20px;
`;

export default function ({ participant, match }) {
  return (
    <ContentWrapper win={participant.win}>
      <MatchStats>
        {getGameType(match.queueId)}
        <br />
        {winOrLose(participant.win)}
      </MatchStats>
      <MatchStats>
        <ChampionImgBig img={`https://ddragon.leagueoflegends.com/cdn/12.1.1/img/champion/${participant.championName}.png`}></ChampionImgBig>
        {participant.championName}
      </MatchStats>
      <KDA>
        {participant.kills} / {participant.deaths} / {participant.assists}
        <br />
        평점: {getKDA(participant.kills, participant.deaths, participant.assists)}
      </KDA>
      <br />
      {/* <span>
        {match.participants.map((p) => (
          <span> [ {p.summonerName} ] </span>
        ))}
        <br />
      </span> */}
    </ContentWrapper>
  );
}
