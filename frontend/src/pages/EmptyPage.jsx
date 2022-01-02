import { Link } from "react-router-dom";

export default function () {
  return (
    <>
      <h1>요청하신 페이지를 찾을 수 없습니다.</h1>
      <Link to="/">메인으로</Link>
    </>
  );
}
