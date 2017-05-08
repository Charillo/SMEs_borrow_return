package phromphong.smes_borrow_return;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by phrompongkhagtes on 4/26/2017 AD.
 */

public interface OPPMSService {

    @POST("application/views/inventory/borrow/Andriod_SMEs/SMES_select_borrow_return.php")
    Call<OPPMSDAO> getOPPMSData(); //รับข้อมูล



}
