import styled from "styled-components";

const Img = styled.div`
  background-image: url(${(props) => props.img});
  background-size: contain;
  background-repeat: no-repeat;
  text-align: center;
  width: 24px;
  height: 24px;
  margin: 2px 0px 2px 0px;
`;

export default function ({ url, style }) {
  return <Img style={style} img={url}></Img>;
}
