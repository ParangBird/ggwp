export const bodyColor = "#ebf5ff";

export const getTierColor = (tier) => {
  switch (tier) {
    case "IRON":
      return "#94868B";
    case "BRONZE":
      return "#B97451";
    case "SILVER":
      return "#779fa9";
    case "GOLD":
      return "#F1A64D";
    case "PLATINUM":
      return "#328080";
    case "DIAMOND":
      return "#738DF9";
    case "MASTER":
      return "#9D5DDD";
    case "GRANDMASTER":
      return "#EF4F4F";
    case "CHALLENGER":
      return "#dd8650";
  }
};
