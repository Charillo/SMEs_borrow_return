package phromphong.smes_borrow_return;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by phrompongkhagtes on 4/26/2017 AD.
 */

public class OPPMSDAO {

    @SerializedName("details")
    public ArrayList<BorrowReturn> details;
}
