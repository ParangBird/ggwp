export const getSpellImgUrl = (id) => {
  return "http://ddragon.leagueoflegends.com/cdn/12.1.1/img/spell/" + id + ".png";
};

export const getChampImgUrl = (championName) => {
  if (championName == "FiddleSticks") championName = "Fiddlesticks";
  return "https://ddragon.leagueoflegends.com/cdn/12.1.1/img/champion/" + championName + ".png";
};

export const getPerkImgUrl = (perkDir) => {
  return "http://ddragon.leagueoflegends.com/cdn/img/" + perkDir;
};

export const getItemImgUrl = (item) => {
  return "https://ddragon.leagueoflegends.com/cdn/12.1.1/img/item/" + item + ".png";
};
