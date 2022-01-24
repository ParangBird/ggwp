export const getWinRate = (wins, losses) => {
  return ((wins / (losses + wins)) * 100).toFixed(2);
};

export const getKillEngage = (kill, totalKill) => {
  return ((kill / totalKill) * 100).toFixed(0);
};

export const getCsPerMin = (cs, time) => {
  let min = Math.floor(time / 60);
  return (cs / min).toFixed(1);
};

export const multiStr = (str) => {
  if (str == "") return [];
  str = str.replace(/\s/g, ""); //모든 공백 제거
  str = str.replace(/\n/g, ""); //모든 개행 제거
  str = str.replace(/\./g, ","); // 모든 . 를 ,로 바꿈
  //아래는 여러가지 예신데 님이 ~ 다, 전체를 바꾸는방법 있으면 좋을듯 아님말고
  str = str.replace(/\님이방에참가하셨습니다,/g, ",");
  str = str.replace(/\님이채팅방에참가하셨습니다,/g, ",");
  str = str.replace(/\님이채팅창에참가하셨습니다,/g, ",");
  str = str.replace(/\님이로비에참가하셨습니다,/g, ",");
  str = str.replace(/\,+$/, ""); //마지막 , 를 제거
  return str.split(",");
};

export const getGameType = (queueId) => {
  switch (queueId) {
    case 420:
      return "솔로랭크";
    case 430:
      return "일반";
    case 440:
      return "자유랭크";
    case 700:
      return "격전";
    case 900:
      return "우르프";
    case 920:
      return "포로킹";
    case 450:
      return "칼바람";
    default:
      return "커스텀";
  }
};

export const winOrLose = (win) => {
  if (win) return "승리";
  else return "패배";
};

export const getKDA = (kills, deaths, assists) => {
  if (!deaths) return "Perfect";
  return ((kills + assists) / deaths).toFixed(2);
};

export const getTimeInfo = (time) => {
  let min = Math.floor(time / 60);
  let sec = time - min * 60;
  return min + "분 " + sec + "초";
};

export const getTimeHasBeen = (value) => {
  const today = new Date();
  const timeValue = new Date(value);

  const betweenTime = Math.floor((today.getTime() - timeValue.getTime()) / 1000 / 60);
  if (betweenTime < 1) return "방금전";
  if (betweenTime < 60) {
    return `${betweenTime}분전`;
  }

  const betweenTimeHour = Math.floor(betweenTime / 60);
  if (betweenTimeHour < 24) {
    return `${betweenTimeHour}시간전`;
  }

  const betweenTimeDay = Math.floor(betweenTime / 60 / 24);
  if (betweenTimeDay < 365) {
    return `${betweenTimeDay}일전`;
  }

  return `${Math.floor(betweenTimeDay / 365)}년전`;
};
