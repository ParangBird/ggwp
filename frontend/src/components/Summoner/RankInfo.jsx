import styled from "styled-components";
import { getTierColor } from "../common/colors";
import { getWinRate } from "../common/cal";

const ContentWrapper = styled.div`
  display: flex;
  margin-bottom: 20px;
  padding: 20px 0px;
  border: 1px solid #b5babf;
  background-color: #d5dee78c;
`;

const RankImg = styled.img`
  width: ${(props) => props.imgSize + "px"};
  height: ${(props) => props.imgSize + "px"};
  margin: 0px 15px 0px 20px;
`;

const RankInfo = styled.div`
  font-size: 15px;
`;

const queueType = (queueType) => {
  if (queueType === "RANKED_SOLO_5x5") {
    return "솔로랭크";
  } else {
    return "자유랭크";
  }
};

export default function ({ rank = {}, imgSize }) {
  let rankImgSource = "/images/emblem/Emblem_" + rank.tier + ".png";

  return (
    <ContentWrapper>
      <RankImg src={rankImgSource} imgSize={imgSize} />
      <RankInfo>
        <span style={{ color: "gray", fontSize: "14px" }}>
          {queueType(rank.queueType)}
          <br />
        </span>
        <span style={{ color: getTierColor(rank.tier), fontSize: "17px" }}>
          {rank.tier} {rank.rank}
          <br />
        </span>
        <span style={{ fontWeight: 600 }}>
          {rank.leaguePoints} LP
          <br />
        </span>
        <span>
          {rank.wins}승 / {rank.losses}패 ({getWinRate(rank.wins, rank.losses)}%)
        </span>
      </RankInfo>
    </ContentWrapper>
  );
}
