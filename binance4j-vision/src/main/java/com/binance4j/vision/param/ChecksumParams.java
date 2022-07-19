package com.binance4j.vision.param;

import java.util.Scanner;

import com.binance4j.core.Request;
import com.binance4j.core.callback.ApiCallback;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exception.NotFoundException;
import com.binance4j.vision.dto.VisionChecksum;

import okhttp3.ResponseBody;
import retrofit2.Call;

/** Vision data checksum request */
public class ChecksumParams extends Request<ResponseBody> {
	/**
	 * @param call The API call.
	 */
	public ChecksumParams(Call<ResponseBody> call) {
		super(call);
	}

	/**
	 * Retrieves the checksum from the response body
	 *
	 * @param res The response body.
	 * @return The checksum wrapper.
	 */
	private VisionChecksum resToChecksum(ResponseBody res) {
		Scanner sc = new Scanner(res.byteStream());
		String[] data = { "" };
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			data = line.split("\\s+");
		}
		sc.close();
		return new VisionChecksum(data[0], data[1]);
	}

	/**
	 * @return The checksum.
	 * @throws ApiException Thrown if data fetching failed.
	 */
	public VisionChecksum getChecksum() throws ApiException {
		return resToChecksum(execute());
	}

	@Override
	public ResponseBody execute() throws ApiException {
		try {
			return super.execute();
		} catch (Exception e) {
			throw new NotFoundException();
		}
	}

	/**
	 * Downloads the zip file asynchronously
	 *
	 * @param callback The callback handling the deserialized data and the API response error.
	 */
	public void getChecksum(ApiCallback<VisionChecksum> callback) {
		then(new ApiCallback<ResponseBody>() {
			@Override
			public void onFailure(ApiException exception) {
				callback.onFailure(exception);
			}

			@Override
			public void onResponse(ResponseBody res) {
				callback.onResponse(resToChecksum(res));
			}
		});
	}
}
