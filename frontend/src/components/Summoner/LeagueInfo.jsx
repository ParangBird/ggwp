import RankInfo from "./RankInfo";
import styled from "styled-components";

const ContentWrapper = styled.div`
  width: 340px;
  text-align: left;
`;

const SoloRank = (soloRank, imgSize) => {
  if (soloRank.leagueId == null) return;
  return <RankInfo imgSize={imgSize} rank={soloRank} />;
};

const FlexRank = (flexRank, imgSize) => {
  if (flexRank.leagueId == null) return;
  return <RankInfo imgSize={imgSize} rank={flexRank} />;
};

export default function ({ soloRank = {}, flexRank = {}, imgSize }) {
  return (
    <ContentWrapper>
      {SoloRank(soloRank, imgSize)}
      {FlexRank(flexRank, imgSize)}
    </ContentWrapper>
  );
}
