export const getSpellImgUrl = (id) => {
  return "http://ddragon.leagueoflegends.com/cdn/12.1.1/img/spell/" + id + ".png";
};

export const getChampImgUrl = (championName) => {
  return "https://ddragon.leagueoflegends.com/cdn/12.1.1/img/champion/" + championName + ".png";
};

export const getPerkImgUrl = (perkDir) => {
  return "http://ddragon.leagueoflegends.com/cdn/img/" + perkDir;
};
