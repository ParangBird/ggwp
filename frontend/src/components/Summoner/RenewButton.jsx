import axios from "axios";
import { Button } from "react-bootstrap";
import { useParams } from "react-router-dom";

export default function () {
  const userName = useParams().name;
  const url = "/api/matches/update/" + userName;

  const onClick = () => {
    axios
      .get(url)
      .then(() => {
        window.location.replace("/search/" + userName);
        console.log("업데이트 성공");
      })
      .catch(() => {
        console.log("업데이트 실패");
      });
  };

  return (
    <Button onClick={onClick} style={{ marginTop: "5px" }} size="sm" variant="secondary">
      전적 갱신
    </Button>
  );
}
