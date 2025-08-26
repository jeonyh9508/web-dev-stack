package com.tester;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SlackStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String json = """
        {
          "status": "active",
          "date_created": "2019-04-09T07:35:46-07:00",
          "date_updated": "2019-04-09T07:35:46-07:00",
          "active_incidents": [
            {
              "id": "546",
              "date_created": "2018-09-07T14:35:00-07:00",
              "date_updated": "2018-09-07T18:34:15-07:00",
              "title": "Slack’s forwarding email feature is failing for some customers",
              "type": "incident",
              "status": "active",
              "url": "https://slack-status.com/2018-09/7dea1cd14cd0f657",
              "services": ["Apps/Integrations/APIs"],
              "notes": [
                {
                  "date_created": "2018-09-07T18:34:15-07:00",
                  "body": "Technical Summary:\\r\\nOn September 7th at 2:35pm PT, we received reports that emails were failing to deliver to Slack forwarding addresses..."
                }
              ]
            }
          ]
        }
        """;

        PrintWriter out = resp.getWriter();
        out.print(json);
    }
}
