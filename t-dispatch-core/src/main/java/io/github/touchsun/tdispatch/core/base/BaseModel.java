package io.github.touchsun.tdispatch.core.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.github.touchsun.tdispatch.core.constant.ConstantNumber;
import io.github.touchsun.tdispatch.core.sso.SsoUser;
import lombok.Data;

import java.util.Date;

/**
 * 基础模型
 *
 * @author lee
 * @since 2023/6/2 22:07
 */
@Data
public class BaseModel {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 逻辑删除
     */
    @TableLogic(value = "0", delval = "1")
    private Integer del;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建者
     */
    private Integer createUserId;

    /**
     * 更新者
     */
    private Integer updateUserId;

    /**
     * 创建者名称
     */
    private String createUserName;

    /**
     * 更新者名称
     */
    private String updateUserName;

    public void parseUser(SsoUser ssoUser) {
        createUserId = ssoUser.getId();
        createUserName = ssoUser.getUserName();
        updateUserId = ssoUser.getId();
        updateUserName = ssoUser.getUserName();
    }

    public static BaseModel newInstance(SsoUser ssoUser, boolean update) {
        BaseModel baseModel = new BaseModel();
        if (!update) {
            baseModel.parseUser(ssoUser);
            baseModel.setCreateTime(new Date());
            baseModel.setUpdateTime(new Date());
            baseModel.setDel(ConstantNumber.ZERO);
        } else {
            baseModel.setUpdateUserName(ssoUser.getUserName());
            baseModel.setUpdateUserId(ssoUser.getId());
            baseModel.setUpdateTime(new Date());
        }
        return baseModel;
    }
}
