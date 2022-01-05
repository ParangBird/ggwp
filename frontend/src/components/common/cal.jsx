export const getWinRate = (wins, losses) => {
  return ((wins / (losses + wins)) * 100).toFixed(2);
};
