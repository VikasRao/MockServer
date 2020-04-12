package com.test.mockserverespresso

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse

import okhttp3.mockwebserver.RecordedRequest


/**
 * Created by Vikas Rao on 29,March,2020
 *
 */
class MockServerDispatcher : Dispatcher() {
    /**
     * Return ok response from mock server
     */

    override fun dispatch(request: RecordedRequest): MockResponse {
        return when {
            request.path!!.equals("/todos/1", true) -> {
                MockResponse().setResponseCode(200).setBody("{\n" +
                        "  \"userId\": 1,\n" +
                        "  \"id\": 1,\n" +
                        "  \"title\": \"delectus aut autem\",\n" +
                        "  \"completed\": false\n" +
                        "}")
            }
            request.path!!.equals("api/codes", true) -> {
                MockResponse().setResponseCode(200).setBody("{codes:FakeCode}")
            }
            request.path == "api/number" -> MockResponse().setResponseCode(200).setBody("number:FakeNumber")
            else -> MockResponse().setResponseCode(404)
        }
    }
}

