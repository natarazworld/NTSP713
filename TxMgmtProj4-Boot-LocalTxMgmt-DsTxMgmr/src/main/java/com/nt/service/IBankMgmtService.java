package com.nt.service;

import java.sql.SQLException;

public interface IBankMgmtService {
    public boolean  transferMoney(long srcAcno, long destAcno ,double amount)throws SQLException;
}
