package com.profidata.domain.valueObject;

import java.util.Objects;
//Nu au identitate proprie. Sunt folosite pentru valori pure
//ID-ul unui Order ESTE un Value Object. nu are comportament / nu are identitate proprie (este chiar identitatea)

public record OrderId(String value) { public OrderId { Objects.requireNonNull(value); } }