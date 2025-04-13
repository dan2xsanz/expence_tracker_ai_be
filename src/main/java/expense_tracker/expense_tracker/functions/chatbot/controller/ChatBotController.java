package expense_tracker.expense_tracker.functions.chatbot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import expense_tracker.expense_tracker.config.exemption.ExemptionError;
import expense_tracker.expense_tracker.config.exemption.ExemptionErrorMessages;
import expense_tracker.expense_tracker.functions.chatbot.dto.ChatBotDto;
import expense_tracker.expense_tracker.model.ApiResultModel;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/chat-bmo")
public class ChatBotController {

    @PostMapping("/ask-me")
    @ResponseStatus(HttpStatus.OK)
    public ApiResultModel handleQuery(@RequestBody ChatBotDto chatBotDto) throws IOException {

        //  String prompt = "Determine the exact enumeration for the expense based on this user's question:\n" +
        //  "User: \"" + userQuery + "\"\n" +
        //  "The possible time period enums are: 'today', 'week', 'month', 'date', 'range'.\n" +
        //  "Identify the time period and relevant date(s) from the user's question.\n" +
        //  "Output the following in this exact format:\n" +
        //  "1. Value: [Enum] (e.g., 'today', 'week', 'month', 'date', 'range')\n" +
        //  "2. Date: [mm/dd/yyyy] (if the question specifies a specific date)\n" +
        //  "3. From: [mm/dd/yyyy] (if the question refers to a range, specify the start date)\n" +
        //  "4. To: [mm/dd/yyyy] (if the question refers to a range, specify the end date)\n" +
        //  "Value: [Enum]\n" +
        //  "Date: [mm/dd/yyyy] (if applicable)\n" +
        //  "From: [mm/dd/yyyy] (if applicable)\n" +
        //  "To: [mm/dd/yyyy] (if applicable)\n";

        // Append the new user query to the conversation history
        // conversationHistory.append("User: \"").append(prompt).append("\"\n");

        // Hugging Face API request body
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("inputs", chatBotDto.getQuery());

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBodyContent = objectMapper.writeValueAsString(requestMap);

        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        okhttp3.RequestBody requestBody = okhttp3.RequestBody.create(requestBodyContent, mediaType);

        Request request = new Request.Builder()
                .url("https://api-inference.huggingface.co/models/mistralai/Mistral-7B-Instruct-v0.1")
                .post(requestBody)
                .addHeader("Authorization", "Bearer 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")
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = client.newCall(request).execute();
        String aiResponse = response.body().string();

        JSONArray responseJson;
        try {
            responseJson = new JSONArray(aiResponse);
        } catch (Exception e) {
            System.out.println("Hugging Face API Response Error: " + aiResponse);
            throw new ExemptionError(ExemptionErrorMessages.THIRD_PARTY_ERROR_MESSAGE);

        }

        String content = responseJson.getJSONObject(0).getString("generated_text");

        // Remove everything before the first line break (to remove the echoed question)
        int firstLineBreak = content.indexOf("\n");
        if (firstLineBreak != -1) {
            content = content.substring(firstLineBreak + 1).trim();

        }

        return ApiResultModel.builder()
                .resultData(content)
                .isSuccess(true)
                .build();
    }
}
