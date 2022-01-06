export const getWinRate = (wins, losses) => {
  return ((wins / (losses + wins)) * 100).toFixed(2);
};

export const getGameType = (queueId) => {
  switch (queueId) {
    case 420:
      return "솔로랭크";
    case 430:
      return "일반";
    case 440:
      return "자유랭크";
    case 900:
      return "우르프";
    case 920:
      return "포로킹";
    case 450:
      return "칼바람나락";
    default:
      return "커스텀";
  }
};

export const winOrLose = (win) => {
  if (win) return "승리";
  else return "패배";
};

export const getKDA = (kills, deaths, assists) => {
  return ((kills + assists) / deaths).toFixed(2);
};
