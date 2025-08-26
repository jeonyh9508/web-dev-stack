document.addEventListener("DOMContentLoaded", function () {
  fetch("status")
    .then((res) => res.json())
    .then((data) => {
      const container = document.getElementById("incident-container");
      const incidents = data.active_incidents || [];

      if (incidents.length === 0) {
        container.innerHTML = "<p>현재 활성화된 인시던트가 없습니다.</p>";
        return;
      }

      incidents.forEach((item) => {
        const div = document.createElement("div");
        div.className = "incident-card";

        div.innerHTML = `
          <h2>${item.title}</h2>
          <p><strong>상태:</strong> ${item.status}</p>
          <p><strong>서비스:</strong> ${item.services.join(", ")}</p>
          <p><strong>노트:</strong><br>${item.notes[0]?.body || "없음"}</p>
          <a href="${item.url}" target="_blank">자세히 보기</a>
        `;

        container.appendChild(div);
      });
    })
    .catch((err) => {
      document.getElementById("incident-container").innerHTML =
        "<p>데이터를 불러오지 못했습니다.</p>";
      console.error(err);
    });
});
