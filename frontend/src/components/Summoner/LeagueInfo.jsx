import RankInfo from "./RankInfo";
import styled from "styled-components";

const ContentWrapper = styled.div`
  width: 340px;
  text-align: left;
`;

const SoloRank = (soloRank) => {
  if (soloRank.leagueId == null) return;
  return <RankInfo rank={soloRank} />;
};

const FlexRank = (flexRank) => {
  if (flexRank.leagueId == null) return;
  return <RankInfo rank={flexRank} />;
};

export default function ({ soloRank = {}, flexRank = {} }) {
  return (
    <ContentWrapper>
      {SoloRank(soloRank)}
      {FlexRank(flexRank)}
    </ContentWrapper>
  );
}
