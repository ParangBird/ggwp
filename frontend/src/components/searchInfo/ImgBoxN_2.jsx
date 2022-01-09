import styled from "styled-components";
import SmallImg from "./SmallImg";
import { itemBackground } from "../common/colors";

const Spell = styled.div`
  display: table-cell;
  vertical-align: middle;
  width: 26px;
`;

const ImgStyle = {
  backgroundColor: itemBackground,
  borderRadius: "4px",
};

export default function ({ img = [], row, count }) {
  let darwedCal = 0;

  const drawImg = (idx) => {
    const result = [];
    if (idx < count) {
      result.push(<SmallImg style={ImgStyle} url={img[darwedCal++]} />);
    } else {
      result.push(<SmallImg />);
    }
    return result;
  };

  const drawBox = () => {
    const result = [];
    for (let i = 0; i < row; i++) {
      result.push(
        <Spell>
          {drawImg(darwedCal)}
          {drawImg(darwedCal)}
        </Spell>
      );
    }
    return result;
  };

  return <>{drawBox()}</>;
}
