require("dotenv").config();
const express = require("express");
const { Client } = require("@notionhq/client");

const app = express();
const port = 3000;

// Notion 클라이언트 초기화
const notion = new Client({ auth: process.env.NOTION_TOKEN });

// 데이터베이스 조회 API
app.get("/notion-data", async (req, res) => {
  try {
    const response = await notion.databases.query({
      database_id: process.env.NOTION_DATABASE_ID,
    });

    const results = response.results.map((page) => {
      return {
        id: page.id,
        title: page.properties.Name.title[0]?.plain_text || "No Title",
        tags: page.properties.Tags.multi_select.map((tag) => tag.name),
      };
    });

    res.json(results);
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: "Notion API 호출 실패" });
  }
});

app.listen(port, () => {
  console.log(`Server is running on http://localhost:${port}`);
});
