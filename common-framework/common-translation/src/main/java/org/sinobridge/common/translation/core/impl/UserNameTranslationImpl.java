package org.sinobridge.common.translation.core.impl;

import org.sinobridge.common.core.service.UserService;
import org.sinobridge.common.translation.annotation.TranslationType;
import org.sinobridge.common.translation.constant.TransConstant;
import org.sinobridge.common.translation.core.TranslationInterface;
import lombok.AllArgsConstructor;

/**
 * 用户名翻译实现
 *
 * @author Zhao Yun
 */
@AllArgsConstructor
@TranslationType(type = TransConstant.USER_ID_TO_NAME)
public class UserNameTranslationImpl implements TranslationInterface<String> {

    private final UserService userService;

    @Override
    public String translation(Object key, String other) {
        if (key instanceof Long id) {
            return userService.selectUserNameById(id);
        }
        return null;
    }
}
