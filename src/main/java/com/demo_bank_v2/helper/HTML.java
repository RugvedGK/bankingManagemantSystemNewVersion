package com.demo_bank_v2.helper;

public class HTML {
	public static String htmlEmailTemplate(String token, int code){
        String url = "http://localhost:1441/verify?token=" + token + "&code=" + code;

String emailTemplate = "<!DOCTYPE html>\n" +
        "<html lang='en'>\n" +
        "<head>\n" +
        "    <meta charset='UTF-8'>\n" +
        "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
        "    <!-- <link rel='stylesheet' href='./css/email.css'> -->\n" +
        "    <title>Document</title>\n" +
        "    <style>\n" +
        "        *{\n" +
        "    box-sizing: border-box;\n" +
        "    font-family: Comfortaa;\n" +
        "}\n" +
        "\n" +
        "body{\n" +
        "    height: 100vh;\n" +
        "    background-color: rgb(212, 222, 230);\n" +
        "    display: flex;\n" +
        "    align-items: center;\n" +
        "    justify-content: center;\n" +
        "}\n" +
        "\n" +
        ".wrapper{\n" +
        "    width: 550px;\n" +
        "    height: auto;\n" +
        "    padding: 15px;\n" +
        "    background-color: white;\n" +
        "    border-radius: 7px;\n" +
        "}\n" +
        "\n" +
        ".email-msg-header{\n" +
        "    text-align: center;\n" +
        "\n" +
        "}\n" +
        "\n" +
        ".company-name {\n" +
        "    width: 100%;\n" +
        "    text-align: center;\n" +
        "    font-size: 35px;\n" +
        "    color: gray;\n" +
        "}\n" +
        "\n" +
        ".welcome-text{\n" +
        "    text-align: center;\n" +
        "    font-size: large;\n" +
        "}\n" +
        "\n" +
        ".verify-account-btn{\n" +
        "    padding: 15px;\n" +
        "    background-color: rgb(0, 100, 252);\n" +
        "    color: white;\n" +
        "    border-radius: 5px;\n" +
        "    text-decoration: none;\n" +
        "}\n" +
        "\n" +
        "\n" +
        "\n" +
        ".copy-right{\n" +
        "    /* text-align: center; */\n" +
        "    padding: 15px;\n" +
        "    color: gray;\n" +
        "    font-size: 14px;\n" +
        "    margin: 20px 0;\n" +
        "    display: flex;\n" +
        "    align-items: center;\n" +
        "    justify-content: center;\n" +
        "}\n" +
        "\n" +
        "    </style>\n" +
        "</head>\n" +
        "<body>\n" +
        "\n" +
        "    <div class='wrapper'>\n" +
        "        <h2 class='email-msg-header'>\n" +
        "            Welcome and Thanks You for Choosing\n" +
        "        </h2>\n" +
        "        <div class='company-name'>Easy Way Bank</div>\n" +
        "        <hr>\n" +
        "        <p class='welcome-text'>\n" +
        "            Your Account has been successfully registered, please click <br>\n" +
        "             below to verify your account\n" +
        "        </p>\n" +
        "        <br>\n" +
        "        <br>\n" +
        "        <center><a href='"+ url +"' class='verify-account-btn' role='button'>Verify Account</a></center>\n" +
        "\n" +
        "        <div class='copy-right'>\n" +
        "            &copy; Copy Right 2024. All Rights Reserved.\n" +
        "        </div>\n" +
        "    </div>\n" +
        "</body>\n" +
        "</html>";
        return emailTemplate;
    }

}
