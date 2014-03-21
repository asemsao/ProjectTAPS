! function (a) {
    "use strict";
    a.Zebra_DatePicker = function (b, c) {
        var d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N = {
                always_visible: !1,
                days: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
                days_abbr: !1,
                direction: 0,
                disabled_dates: !1,
                enabled_dates: !1,
                first_day_of_week: 1,
                format: "Y-m-d",
                header_captions: {
                    days: "F, Y",
                    months: "Y",
                    years: "Y1 - Y2"
                },
                header_navigation: ["&#171;", "&#187;"],
                inside: !0,
                lang_clear_date: "Clear date",
                months: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
                months_abbr: !1,
                offset: [5, -5],
                pair: !1,
                readonly_element: !0,
                select_other_months: !1,
                show_clear_date: 0,
                show_icon: !0,
                show_other_months: !0,
                show_select_today: "Today",
                show_week_number: !1,
                start_date: !1,
                strict: !1,
                view: "days",
                weekend_days: [0, 6],
                zero_pad: !1,
                onChange: null,
                onClear: null,
                onSelect: null
            }, O = this;
        O.settings = {};
        var P = a(b),
            Q = function (b) {
                if (!b) {
                    O.settings = a.extend({}, N, c);
                    for (var y in P.data()) 0 === y.indexOf("zdp_") && (y = y.replace(/^zdp\_/, ""), void 0 !== N[y] && (O.settings[y] = "pair" == y ? a(P.data("zdp_" + y)) : P.data("zdp_" + y)))
                }
                O.settings.readonly_element && P.attr("readonly", "readonly");
                var E = {
                    days: ["d", "j", "D"],
                    months: ["F", "m", "M", "n", "t"],
                    years: ["o", "Y", "y"]
                }, F = !1,
                    G = !1,
                    Q = !1,
                    T = null;
                for (T in E) a.each(E[T], function (a, b) {
                    O.settings.format.indexOf(b) > -1 && ("days" == T ? F = !0 : "months" == T ? G = !0 : "years" == T && (Q = !0))
                });
                H = F && G && Q ? ["years", "months", "days"] : !F && G && Q ? ["years", "months"] : F || G || !Q ? F || !G || Q ? ["years", "months", "days"] : ["months"] : ["years"], -1 == a.inArray(O.settings.view, H) && (O.settings.view = H[H.length - 1]), x = [], w = [];
                for (var U, V = 0; 2 > V; V++) U = 0 === V ? O.settings.disabled_dates : O.settings.enabled_dates, a.isArray(U) && U.length > 0 && a.each(U, function () {
                    for (var b = this.split(" "), c = 0; 4 > c; c++) {
                        b[c] || (b[c] = "*"), b[c] = b[c].indexOf(",") > -1 ? b[c].split(",") : new Array(b[c]);
                        for (var d = 0; d < b[c].length; d++)
                            if (b[c][d].indexOf("-") > -1) {
                                var e = b[c][d].match(/^([0-9]+)\-([0-9]+)/);
                                if (null !== e) {
                                    for (var f = eb(e[1]); f <= eb(e[2]); f++) - 1 == a.inArray(f, b[c]) && b[c].push(f + "");
                                    b[c].splice(d, 1)
                                }
                            }
                        for (d = 0; d < b[c].length; d++) b[c][d] = isNaN(eb(b[c][d])) ? b[c][d] : eb(b[c][d])
                    }
                    0 === V ? x.push(b) : w.push(b)
                });
                var W, X, Y = new Date,
                    _ = O.settings.reference_date ? O.settings.reference_date : P.data("zdp_reference_date") && void 0 !== P.data("zdp_reference_date") ? P.data("zdp_reference_date") : Y;
                if (z = void 0, A = void 0, o = _.getMonth(), l = Y.getMonth(), p = _.getFullYear(), m = Y.getFullYear(), q = _.getDate(), n = Y.getDate(), O.settings.direction === !0) z = _;
                else if (O.settings.direction === !1) A = _, D = A.getMonth(), C = A.getFullYear(), B = A.getDate();
                else if (!a.isArray(O.settings.direction) && $(O.settings.direction) && eb(O.settings.direction) > 0 || a.isArray(O.settings.direction) && ((W = R(O.settings.direction[0])) || O.settings.direction[0] === !0 || $(O.settings.direction[0]) && O.settings.direction[0] > 0) && ((X = R(O.settings.direction[1])) || O.settings.direction[1] === !1 || $(O.settings.direction[1]) && O.settings.direction[1] >= 0)) z = W ? W : new Date(p, o, q + (a.isArray(O.settings.direction) ? eb(O.settings.direction[0] === !0 ? 0 : O.settings.direction[0]) : eb(O.settings.direction))), o = z.getMonth(), p = z.getFullYear(), q = z.getDate(), X && +X >= +z ? A = X : !X && O.settings.direction[1] !== !1 && a.isArray(O.settings.direction) && (A = new Date(p, o, q + eb(O.settings.direction[1]))), A && (D = A.getMonth(), C = A.getFullYear(), B = A.getDate());
                else if (!a.isArray(O.settings.direction) && $(O.settings.direction) && eb(O.settings.direction) < 0 || a.isArray(O.settings.direction) && (O.settings.direction[0] === !1 || $(O.settings.direction[0]) && O.settings.direction[0] < 0) && ((W = R(O.settings.direction[1])) || $(O.settings.direction[1]) && O.settings.direction[1] >= 0)) A = new Date(p, o, q + (a.isArray(O.settings.direction) ? eb(O.settings.direction[0] === !1 ? 0 : O.settings.direction[0]) : eb(O.settings.direction))), D = A.getMonth(), C = A.getFullYear(), B = A.getDate(), W && +A > +W ? z = W : !W && a.isArray(O.settings.direction) && (z = new Date(C, D, B - eb(O.settings.direction[1]))), z && (o = z.getMonth(), p = z.getFullYear(), q = z.getDate());
                else if (a.isArray(O.settings.disabled_dates) && O.settings.disabled_dates.length > 0)
                    for (var cb in x)
                        if ("*" == x[cb][0] && "*" == x[cb][1] && "*" == x[cb][2] && "*" == x[cb][3]) {
                            var gb = [];
                            if (a.each(w, function () {
                                var a = this;
                                "*" != a[2][0] && gb.push(parseInt(a[2][0] + ("*" == a[1][0] ? "12" : db(a[1][0], 2)) + ("*" == a[0][0] ? "*" == a[1][0] ? "31" : new Date(a[2][0], a[1][0], 0).getDate() : db(a[0][0], 2)), 10))
                            }), gb.sort(), gb.length > 0) {
                                var ib = (gb[0] + "").match(/([0-9]{4})([0-9]{2})([0-9]{2})/);
                                p = parseInt(ib[1], 10), o = parseInt(ib[2], 10) - 1, q = parseInt(ib[3], 10)
                            }
                            break
                        }
                if (Z(p, o, q)) {
                    for (; Z(p);) z ? (p++, o = 0) : (p--, o = 11);
                    for (; Z(p, o);) z ? (o++, q = 1) : (o--, q = new Date(p, o + 1, 0).getDate()), o > 11 ? (p++, o = 0, q = 1) : 0 > o && (p--, o = 11, q = new Date(p, o + 1, 0).getDate());
                    for (; Z(p, o, q);) z ? q++ : q--, Y = new Date(p, o, q), p = Y.getFullYear(), o = Y.getMonth(), q = Y.getDate();
                    Y = new Date(p, o, q), p = Y.getFullYear(), o = Y.getMonth(), q = Y.getDate()
                }
                var jb = R(P.val() || (O.settings.start_date ? O.settings.start_date : ""));
                if (jb && O.settings.strict && Z(jb.getFullYear(), jb.getMonth(), jb.getDate()) && P.val(""), b || fb(z), !O.settings.always_visible) {
                    if (!b) {
                        if (O.settings.show_icon) {
                            "firefox" == hb.name && P.is('input[type="text"]') && "inline" == P.css("display");
                            var kb = jQuery('<span class="Zebra_DatePicker_Icon_Wrapper"></span>').css({
                                display: P.css("display"),
                                position: "static" == P.css("position") ? "relative" : P.css("position"),
                                "float": P.css("float"),
                                top: P.css("top"),
                                right: P.css("right"),
                                bottom: P.css("bottom"),
                                left: P.css("left")
                            });
                            P.wrap(kb).css({
                                position: "relative",
                                top: "auto",
                                right: "auto",
                                bottom: "auto",
                                left: "auto"
                            }), f = jQuery('<button type="button" class="Zebra_DatePicker_Icon' + ("disabled" == P.attr("disabled") ? " Zebra_DatePicker_Icon_Disabled" : "") + '">Pick a date</button>'), O.icon = f, I = f.add(P)
                        } else I = P;
                        I.bind("click", function (a) {
                            a.preventDefault(), P.attr("disabled") || ("none" != e.css("display") ? O.hide() : O.show())
                        }), void 0 !== f && f.insertAfter(P)
                    }
                    if (void 0 !== f) {
                        f.attr("style", ""), O.settings.inside && f.addClass("Zebra_DatePicker_Icon_Inside");
                        var lb = P.outerWidth(),
                            mb = P.outerHeight(),
                            nb = parseInt(P.css("marginLeft"), 10) || 0,
                            ob = parseInt(P.css("marginTop"), 10) || 0,
                            pb = f.outerWidth(),
                            qb = f.outerHeight(),
                            rb = parseInt(f.css("marginLeft"), 10) || 0,
                            sb = parseInt(f.css("marginRight"), 10) || 0;
                        O.settings.inside ? f.css({
                            top: ob + (mb - qb) / 2,
                            left: nb + (lb - pb - sb)
                        }) : f.css({
                            top: ob + (mb - qb) / 2,
                            left: nb + lb + rb
                        })
                    }
                }
                if (L = O.settings.show_select_today !== !1 && a.inArray("days", H) > -1 && !Z(m, l, n) ? O.settings.show_select_today : !1, !b) {
                    a(window).bind("resize.Zebra_DatePicker", function () {
                        O.hide(), void 0 !== f && (clearTimeout(M), M = setTimeout(function () {
                            O.update()
                        }, 100))
                    });
                    var tb = '<div class="Zebra_DatePicker"><table class="dp_header"><tr><td class="dp_previous">' + O.settings.header_navigation[0] + '</td><td class="dp_caption">&#032;</td><td class="dp_next">' + O.settings.header_navigation[1] + '</td></tr></table><table class="dp_daypicker" style="width: 100%; height: 217px; display: none;"></table><table class="dp_monthpicker"></table><table class="dp_yearpicker"></table><table class="dp_footer"><tr><td class="dp_today"' + (O.settings.show_clear_date !== !1 ? ' style="width:50%"' : "") + ">" + L + '</td><td class="dp_clear"' + (L !== !1 ? ' style="width:50%"' : "") + ">" + O.settings.lang_clear_date + "</td></tr></table></div>";
                    e = a(tb), O.datepicker = e, g = a("table.dp_header", e), h = a("table.dp_daypicker", e), i = a("table.dp_monthpicker", e), j = a("table.dp_yearpicker", e), K = a("table.dp_footer", e), J = a("td.dp_today", K), k = a("td.dp_clear", K), O.settings.always_visible ? P.attr("disabled") || (O.settings.always_visible.append(e), O.show()) : a("body").append(e), e.delegate("td:not(.dp_disabled, .dp_weekend_disabled, .dp_not_in_month, .dp_blocked, .dp_week_number)", "mouseover", function () {
                        a(this).addClass("dp_hover")
                    }).delegate("td:not(.dp_disabled, .dp_weekend_disabled, .dp_not_in_month, .dp_blocked, .dp_week_number)", "mouseout", function () {
                        a(this).removeClass("dp_hover")
                    }), S(a("td", g)), a(".dp_previous", g).bind("click", function () {
                        a(this).hasClass("dp_blocked") || ("months" == d ? s-- : "years" == d ? s -= 12 : --r < 0 && (r = 11, s--), ab())
                    }), a(".dp_caption", g).bind("click", function () {
                        d = "days" == d ? a.inArray("months", H) > -1 ? "months" : a.inArray("years", H) > -1 ? "years" : "days" : "months" == d ? a.inArray("years", H) > -1 ? "years" : a.inArray("days", H) > -1 ? "days" : "months" : a.inArray("days", H) > -1 ? "days" : a.inArray("months", H) > -1 ? "months" : "years", ab()
                    }), a(".dp_next", g).bind("click", function () {
                        a(this).hasClass("dp_blocked") || ("months" == d ? s++ : "years" == d ? s += 12 : 12 == ++r && (r = 0, s++), ab())
                    }), h.delegate("td:not(.dp_disabled, .dp_weekend_disabled, .dp_not_in_month, .dp_week_number)", "click", function () {
                        O.settings.select_other_months && null !== (ib = a(this).attr("class").match(/date\_([0-9]{4})(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])/)) ? bb(ib[1], ib[2] - 1, ib[3], "days", a(this)) : bb(s, r, eb(a(this).html()), "days", a(this))
                    }), i.delegate("td:not(.dp_disabled)", "click", function () {
                        var b = a(this).attr("class").match(/dp\_month\_([0-9]+)/);
                        r = eb(b[1]), -1 == a.inArray("days", H) ? bb(s, r, 1, "months", a(this)) : (d = "days", O.settings.always_visible && P.val(""), ab())
                    }), j.delegate("td:not(.dp_disabled)", "click", function () {
                        s = eb(a(this).html()), -1 == a.inArray("months", H) ? bb(s, 1, 1, "years", a(this)) : (d = "months", O.settings.always_visible && P.val(""), ab())
                    }), a(J).bind("click", function (b) {
                        b.preventDefault(), bb(m, l, n, "days", a(".dp_current", h)), O.settings.always_visible && O.show(), O.hide()
                    }), a(k).bind("click", function (b) {
                        b.preventDefault(), P.val(""), O.settings.always_visible ? (t = null, u = null, v = null, a("td.dp_selected", e).removeClass("dp_selected")) : (t = null, u = null, v = null, r = null, s = null), O.hide(), O.settings.onClear && "function" == typeof O.settings.onClear && O.settings.onClear.call(P, P)
                    }), O.settings.always_visible || a(document).bind({
                        "mousedown.Zebra_DatePicker": function (b) {
                            if ("block" == e.css("display")) {
                                if (O.settings.show_icon && a(b.target).get(0) === f.get(0)) return !0;
                                0 === a(b.target).parents().filter(".Zebra_DatePicker").length && O.hide()
                            }
                        },
                        "keyup.Zebra_DatePicker": function (a) {
                            "block" == e.css("display") && 27 == a.which && O.hide()
                        }
                    }), ab()
                }
            };
        O.destroy = function () {
            void 0 !== O.icon && O.icon.remove(), O.datepicker.remove(), a(document).unbind("keyup.Zebra_DatePicker"), a(document).unbind("mousedown.Zebra_DatePicker"), a(window).unbind("resize.Zebra_DatePicker"), P.removeData("Zebra_DatePicker")
        }, O.hide = function () {
            O.settings.always_visible || (Y("hide"), e.hide())
        }, O.show = function () {
            d = O.settings.view;
            var b = R(P.val() || (O.settings.start_date ? O.settings.start_date : ""));
            if (b ? (u = b.getMonth(), r = b.getMonth(), v = b.getFullYear(), s = b.getFullYear(), t = b.getDate(), Z(v, u, t) && (O.settings.strict && P.val(""), r = o, s = p)) : (r = o, s = p), ab(), O.settings.always_visible) e.show();
            else {
                var c = e.outerWidth(),
                    g = e.outerHeight(),
                    h = (void 0 !== f ? f.offset().left + f.outerWidth(!0) : P.offset().left + P.outerWidth(!0)) + O.settings.offset[0],
                    i = (void 0 !== f ? f.offset().top : P.offset().top) - g + O.settings.offset[1],
                    j = a(window).width(),
                    k = a(window).height(),
                    l = a(window).scrollTop(),
                    m = a(window).scrollLeft();
                h + c > m + j && (h = m + j - c), m > h && (h = m), i + g > l + k && (i = l + k - g), l > i && (i = l), e.css({
                    left: h,
                    top: i
                }), e.fadeIn("explorer" == hb.name && hb.version < 9 ? 0 : 150, "linear"), Y()
            }
        }, O.update = function (b) {
            O.original_direction && (O.original_direction = O.direction), O.settings = a.extend(O.settings, b), Q(!0)
        };
        var R = function (b) {
            if (b += "", "" !== a.trim(b)) {
                for (var c = T(O.settings.format), d = ["d", "D", "j", "l", "N", "S", "w", "F", "m", "M", "n", "Y", "y"], e = [], f = [], g = null, h = null, i = 0; i < d.length; i++)(g = c.indexOf(d[i])) > -1 && e.push({
                    character: d[i],
                    position: g
                });
                if (e.sort(function (a, b) {
                    return a.position - b.position
                }), a.each(e, function (a, b) {
                    switch (b.character) {
                    case "d":
                        f.push("0[1-9]|[12][0-9]|3[01]");
                        break;
                    case "D":
                        f.push("[a-z]{3}");
                        break;
                    case "j":
                        f.push("[1-9]|[12][0-9]|3[01]");
                        break;
                    case "l":
                        f.push("[a-z]+");
                        break;
                    case "N":
                        f.push("[1-7]");
                        break;
                    case "S":
                        f.push("st|nd|rd|th");
                        break;
                    case "w":
                        f.push("[0-6]");
                        break;
                    case "F":
                        f.push("[a-z]+");
                        break;
                    case "m":
                        f.push("0[1-9]|1[012]+");
                        break;
                    case "M":
                        f.push("[a-z]{3}");
                        break;
                    case "n":
                        f.push("[1-9]|1[012]");
                        break;
                    case "Y":
                        f.push("[0-9]{4}");
                        break;
                    case "y":
                        f.push("[0-9]{2}")
                    }
                }), f.length && (e.reverse(), a.each(e, function (a, b) {
                    c = c.replace(b.character, "(" + f[f.length - a - 1] + ")")
                }), f = new RegExp("^" + c + "$", "ig"), h = f.exec(b))) {
                    var j, k = new Date,
                        l = k.getDate(),
                        m = k.getMonth() + 1,
                        n = k.getFullYear(),
                        o = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
                        p = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
                        q = !0;
                    if (e.reverse(), a.each(e, function (b, c) {
                        if (!q) return !0;
                        switch (c.character) {
                        case "m":
                        case "n":
                            m = eb(h[b + 1]);
                            break;
                        case "d":
                        case "j":
                            l = eb(h[b + 1]);
                            break;
                        case "D":
                        case "l":
                        case "F":
                        case "M":
                            j = "D" == c.character || "l" == c.character ? O.settings.days : O.settings.months, q = !1, a.each(j, function (a, d) {
                                if (q) return !0;
                                if (h[b + 1].toLowerCase() == d.substring(0, "D" == c.character || "M" == c.character ? 3 : d.length).toLowerCase()) {
                                    switch (c.character) {
                                    case "D":
                                        h[b + 1] = o[a].substring(0, 3);
                                        break;
                                    case "l":
                                        h[b + 1] = o[a];
                                        break;
                                    case "F":
                                        h[b + 1] = p[a], m = a + 1;
                                        break;
                                    case "M":
                                        h[b + 1] = p[a].substring(0, 3), m = a + 1
                                    }
                                    q = !0
                                }
                            });
                            break;
                        case "Y":
                            n = eb(h[b + 1]);
                            break;
                        case "y":
                            n = "19" + eb(h[b + 1])
                        }
                    }), q) {
                        var r = new Date(n, (m || 1) - 1, l || 1);
                        if (r.getFullYear() == n && r.getDate() == (l || 1) && r.getMonth() == (m || 1) - 1) return r
                    }
                }
                return !1
            }
        }, S = function (a) {
                "firefox" == hb.name ? a.css("MozUserSelect", "none") : "explorer" == hb.name ? a.bind("selectstart", function () {
                    return !1
                }) : a.mousedown(function () {
                    return !1
                })
            }, T = function (a) {
                return a.replace(/([-.,*+?^${}()|[\]\/\\])/g, "\\$1")
            }, U = function (b) {
                for (var c = "", d = b.getDate(), e = b.getDay(), f = O.settings.days[e], g = b.getMonth() + 1, h = O.settings.months[g - 1], i = b.getFullYear() + "", j = 0; j < O.settings.format.length; j++) {
                    var k = O.settings.format.charAt(j);
                    switch (k) {
                    case "y":
                        i = i.substr(2);
                    case "Y":
                        c += i;
                        break;
                    case "m":
                        g = db(g, 2);
                    case "n":
                        c += g;
                        break;
                    case "M":
                        h = a.isArray(O.settings.months_abbr) && void 0 !== O.settings.months_abbr[g - 1] ? O.settings.months_abbr[g - 1] : O.settings.months[g - 1].substr(0, 3);
                    case "F":
                        c += h;
                        break;
                    case "d":
                        d = db(d, 2);
                    case "j":
                        c += d;
                        break;
                    case "D":
                        f = a.isArray(O.settings.days_abbr) && void 0 !== O.settings.days_abbr[e] ? O.settings.days_abbr[e] : O.settings.days[e].substr(0, 3);
                    case "l":
                        c += f;
                        break;
                    case "N":
                        e++;
                    case "w":
                        c += e;
                        break;
                    case "S":
                        c += d % 10 == 1 && "11" != d ? "st" : d % 10 == 2 && "12" != d ? "nd" : d % 10 == 3 && "13" != d ? "rd" : "th";
                        break;
                    default:
                        c += k
                    }
                }
                return c
            }, V = function () {
                var b = new Date(s, r + 1, 0).getDate(),
                    c = new Date(s, r, 1).getDay(),
                    d = new Date(s, r, 0).getDate(),
                    e = c - O.settings.first_day_of_week;
                e = 0 > e ? 7 + e : e, _(O.settings.header_captions.days);
                var f = "<tr>";
                O.settings.show_week_number && (f += "<th>" + O.settings.show_week_number + "</th>");
                for (var g = 0; 7 > g; g++) f += "<th>" + (a.isArray(O.settings.days_abbr) && void 0 !== O.settings.days_abbr[(O.settings.first_day_of_week + g) % 7] ? O.settings.days_abbr[(O.settings.first_day_of_week + g) % 7] : O.settings.days[(O.settings.first_day_of_week + g) % 7].substr(0, 2)) + "</th>";
                for (f += "</tr><tr>", g = 0; 42 > g; g++) {
                    g > 0 && g % 7 === 0 && (f += "</tr><tr>"), g % 7 === 0 && O.settings.show_week_number && (f += '<td class="dp_week_number">' + gb(new Date(s, r, g - e + 1)) + "</td>");
                    var i = g - e + 1;
                    if (O.settings.select_other_months && (e > g || i > b)) {
                        var j = new Date(s, r, i),
                            k = j.getFullYear(),
                            o = j.getMonth(),
                            p = j.getDate();
                        j = k + db(o + 1, 2) + db(p, 2)
                    }
                    if (e > g) f += '<td class="' + (O.settings.select_other_months && !Z(k, o, p) ? "dp_not_in_month_selectable date_" + j : "dp_not_in_month") + '">' + (O.settings.select_other_months || O.settings.show_other_months ? db(d - e + g + 1, O.settings.zero_pad ? 2 : 0) : "&nbsp;") + "</td>";
                    else if (i > b) f += '<td class="' + (O.settings.select_other_months && !Z(k, o, p) ? "dp_not_in_month_selectable date_" + j : "dp_not_in_month") + '">' + (O.settings.select_other_months || O.settings.show_other_months ? db(i - b, O.settings.zero_pad ? 2 : 0) : "&nbsp;") + "</td>";
                    else {
                        var q = (O.settings.first_day_of_week + g) % 7,
                            w = "";
                        Z(s, r, i) ? (a.inArray(q, O.settings.weekend_days) > -1 ? w = "dp_weekend_disabled" : w += " dp_disabled", r == l && s == m && n == i && (w += " dp_disabled_current")) : (a.inArray(q, O.settings.weekend_days) > -1 && (w = "dp_weekend"), r == u && s == v && t == i && (w += " dp_selected"), r == l && s == m && n == i && (w += " dp_current")), f += "<td" + ("" !== w ? ' class="' + a.trim(w) + '"' : "") + ">" + (O.settings.zero_pad ? db(i, 2) : i) + "</td>"
                    }
                }
                f += "</tr>", h.html(a(f)), O.settings.always_visible && (E = a("td:not(.dp_disabled, .dp_weekend_disabled, .dp_not_in_month, .dp_blocked, .dp_week_number)", h)), h.show()
            }, W = function () {
                _(O.settings.header_captions.months);
                for (var b = "<tr>", c = 0; 12 > c; c++) {
                    c > 0 && c % 3 === 0 && (b += "</tr><tr>");
                    var d = "dp_month_" + c;
                    Z(s, c) ? d += " dp_disabled" : u !== !1 && u == c && s == v ? d += " dp_selected" : l == c && m == s && (d += " dp_current"), b += '<td class="' + a.trim(d) + '">' + (a.isArray(O.settings.months_abbr) && void 0 !== O.settings.months_abbr[c] ? O.settings.months_abbr[c] : O.settings.months[c].substr(0, 3)) + "</td>"
                }
                b += "</tr>", i.html(a(b)), O.settings.always_visible && (F = a("td:not(.dp_disabled)", i)), i.show()
            }, X = function () {
                _(O.settings.header_captions.years);
                for (var b = "<tr>", c = 0; 12 > c; c++) {
                    c > 0 && c % 3 === 0 && (b += "</tr><tr>");
                    var d = "";
                    Z(s - 7 + c) ? d += " dp_disabled" : v && v == s - 7 + c ? d += " dp_selected" : m == s - 7 + c && (d += " dp_current"), b += "<td" + ("" !== a.trim(d) ? ' class="' + a.trim(d) + '"' : "") + ">" + (s - 7 + c) + "</td>"
                }
                b += "</tr>", j.html(a(b)), O.settings.always_visible && (G = a("td:not(.dp_disabled)", j)), j.show()
            }, Y = function (b) {
                if ("explorer" == hb.name && 6 == hb.version) {
                    if (!y) {
                        var c = eb(e.css("zIndex")) - 1;
                        y = jQuery("<iframe>", {
                            src: 'javascript:document.write("")',
                            scrolling: "no",
                            frameborder: 0,
                            css: {
                                zIndex: c,
                                position: "absolute",
                                top: -1e3,
                                left: -1e3,
                                width: e.outerWidth(),
                                height: e.outerHeight(),
                                filter: "progid:DXImageTransform.Microsoft.Alpha(opacity=0)",
                                display: "none"
                            }
                        }), a("body").append(y)
                    }
                    switch (b) {
                    case "hide":
                        y.hide();
                        break;
                    default:
                        var d = e.offset();
                        y.css({
                            top: d.top,
                            left: d.left,
                            display: "block"
                        })
                    }
                }
            }, Z = function (b, c, d) {
                if ((void 0 === b || isNaN(b)) && (void 0 === c || isNaN(c)) && (void 0 === d || isNaN(d))) return !1;
                if (a.isArray(O.settings.direction) || 0 !== eb(O.settings.direction)) {
                    var e = eb(cb(b, "undefined" != typeof c ? db(c, 2) : "", "undefined" != typeof d ? db(d, 2) : "")),
                        f = (e + "").length;
                    if (8 == f && ("undefined" != typeof z && e < eb(cb(p, db(o, 2), db(q, 2))) || "undefined" != typeof A && e > eb(cb(C, db(D, 2), db(B, 2))))) return !0;
                    if (6 == f && ("undefined" != typeof z && e < eb(cb(p, db(o, 2))) || "undefined" != typeof A && e > eb(cb(C, db(D, 2))))) return !0;
                    if (4 == f && ("undefined" != typeof z && p > e || "undefined" != typeof A && e > C)) return !0
                }
                "undefined" != typeof c && (c += 1);
                var g = !1,
                    h = !1;
                return x && a.each(x, function () {
                    if (!g) {
                        var e = this;
                        if ((a.inArray(b, e[2]) > -1 || a.inArray("*", e[2]) > -1) && ("undefined" != typeof c && a.inArray(c, e[1]) > -1 || a.inArray("*", e[1]) > -1) && ("undefined" != typeof d && a.inArray(d, e[0]) > -1 || a.inArray("*", e[0]) > -1)) {
                            if ("*" == e[3]) return g = !0;
                            var f = new Date(b, c - 1, d).getDay();
                            if (a.inArray(f, e[3]) > -1) return g = !0
                        }
                    }
                }), w && a.each(w, function () {
                    if (!h) {
                        var e = this;
                        if ((a.inArray(b, e[2]) > -1 || a.inArray("*", e[2]) > -1) && (h = !0, "undefined" != typeof c))
                            if (h = !0, a.inArray(c, e[1]) > -1 || a.inArray("*", e[1]) > -1) {
                                if ("undefined" != typeof d)
                                    if (h = !0, a.inArray(d, e[0]) > -1 || a.inArray("*", e[0]) > -1) {
                                        if ("*" == e[3]) return h = !0;
                                        var f = new Date(b, c - 1, d).getDay();
                                        if (a.inArray(f, e[3]) > -1) return h = !0;
                                        h = !1
                                    } else h = !1
                            } else h = !1
                    }
                }), w && h ? !1 : x && g ? !0 : !1
            }, $ = function (a) {
                return (a + "").match(/^\-?[0-9]+$/) ? !0 : !1
            }, _ = function (b) {
                if (a.isNumeric(r) && (b = b.replace(/\bm\b/, db(r + 1, 2)).replace(/\bn\b/, r + 1).replace(/\bF\b/, O.settings.months[r]).replace(/\bM\b/, a.isArray(O.settings.months_abbr) && void 0 !== O.settings.months_abbr[r] ? O.settings.months_abbr[r] : O.settings.months[r].substr(0, 3))), a.isNumeric(s) && (b = b.replace(/\bY\b/, s).replace(/\by\b/, (s + "").substr(2)).replace(/\bY1\b/i, s - 7).replace(/\bY2\b/i, s + 4)), a(".dp_caption", g).html(b), a.isArray(O.settings.direction) || 0 !== eb(O.settings.direction) || 1 == H.length && "months" == H[0]) {
                    var c, e, f = s,
                        h = r;
                    "days" == d ? (e = !Z(0 > h - 1 ? cb(f - 1, "11") : cb(f, db(h - 1, 2))), c = !Z(h + 1 > 11 ? cb(f + 1, "00") : cb(f, db(h + 1, 2)))) : "months" == d ? ((!z || z.getFullYear() <= f - 1) && (e = !0), (!A || A.getFullYear() >= f + 1) && (c = !0)) : "years" == d && ((!z || z.getFullYear() < f - 7) && (e = !0), (!A || A.getFullYear() > f + 4) && (c = !0)), e ? a(".dp_previous", g).removeClass("dp_blocked") : (a(".dp_previous", g).addClass("dp_blocked"), a(".dp_previous", g).removeClass("dp_hover")), c ? a(".dp_next", g).removeClass("dp_blocked") : (a(".dp_next", g).addClass("dp_blocked"), a(".dp_next", g).removeClass("dp_hover"))
                }
            }, ab = function () {
                if ("" === h.text() || "days" == d) {
                    if ("" === h.text()) {
                        O.settings.always_visible || e.css("left", -1e3), e.show(), V();
                        var b = h.outerWidth(),
                            c = h.outerHeight();
                        i.css({
                            width: b,
                            height: c
                        }), j.css({
                            width: b,
                            height: c
                        }), g.css("width", b), K.css("width", b), e.hide()
                    } else V();
                    i.hide(), j.hide()
                } else "months" == d ? (W(), h.hide(), j.hide()) : "years" == d && (X(), h.hide(), i.hide()); if (O.settings.onChange && "function" == typeof O.settings.onChange && void 0 !== d) {
                    var f = "days" == d ? h.find("td:not(.dp_disabled, .dp_weekend_disabled, .dp_not_in_month, .dp_blocked)") : "months" == d ? i.find("td:not(.dp_disabled, .dp_weekend_disabled, .dp_not_in_month, .dp_blocked)") : j.find("td:not(.dp_disabled, .dp_weekend_disabled, .dp_not_in_month, .dp_blocked)");
                    f.each(function () {
                        if ("days" == d)
                            if (a(this).hasClass("dp_not_in_month_selectable")) {
                                var b = a(this).attr("class").match(/date\_([0-9]{4})(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])/);
                                a(this).data("date", b[1] + "-" + b[2] + "-" + b[3])
                            } else a(this).data("date", s + "-" + db(r + 1, 2) + "-" + db(eb(a(this).text()), 2));
                            else if ("months" == d) {
                            var b = a(this).attr("class").match(/dp\_month\_([0-9]+)/);
                            a(this).data("date", s + "-" + db(eb(b[1]) + 1, 2))
                        } else a(this).data("date", eb(a(this).text()))
                    }), O.settings.onChange.call(P, d, f, P)
                }
                K.show(), O.settings.show_clear_date === !0 || 0 === O.settings.show_clear_date && "" !== P.val() || O.settings.always_visible && O.settings.show_clear_date !== !1 ? (k.show(), L ? (J.css("width", "50%"), k.css("width", "50%")) : (J.hide(), k.css("width", "100%"))) : (k.hide(), L ? J.show().css("width", "100%") : K.hide())
            }, bb = function (a, b, c, d, e) {
                var f = new Date(a, b, c, 12, 0, 0),
                    g = "days" == d ? E : "months" == d ? F : G,
                    h = U(f);
                P.val(h), O.settings.always_visible && (u = f.getMonth(), r = f.getMonth(), v = f.getFullYear(), s = f.getFullYear(), t = f.getDate(), g.removeClass("dp_selected"), e.addClass("dp_selected"), "days" == d && e.hasClass("dp_not_in_month_selectable") && O.show()), O.hide(), fb(f), O.settings.onSelect && "function" == typeof O.settings.onSelect && O.settings.onSelect.call(P, h, a + "-" + db(b + 1, 2) + "-" + db(c, 2), f, P, gb(f)), P.focus()
            }, cb = function () {
                for (var a = "", b = 0; b < arguments.length; b++) a += arguments[b] + "";
                return a
            }, db = function (a, b) {
                for (a += ""; a.length < b;) a = "0" + a;
                return a
            }, eb = function (a) {
                return parseInt(a, 10)
            }, fb = function (b) {
                O.settings.pair && a.each(O.settings.pair, function () {
                    var c = a(this);
                    if (c.data && c.data("Zebra_DatePicker")) {
                        var d = c.data("Zebra_DatePicker");
                        d.update({
                            reference_date: b,
                            direction: 0 === d.settings.direction ? 1 : d.settings.direction
                        }), d.settings.always_visible && d.show()
                    } else c.data("zdp_reference_date", b)
                })
            }, gb = function (a) {
                var b, c, d, e, f, g, h, i, j, k = a.getFullYear(),
                    l = a.getMonth() + 1,
                    m = a.getDate();
                return 3 > l ? (b = k - 1, c = (b / 4 | 0) - (b / 100 | 0) + (b / 400 | 0), d = ((b - 1) / 4 | 0) - ((b - 1) / 100 | 0) + ((b - 1) / 400 | 0), e = c - d, f = 0, g = m - 1 + 31 * (l - 1)) : (b = k, c = (b / 4 | 0) - (b / 100 | 0) + (b / 400 | 0), d = ((b - 1) / 4 | 0) - ((b - 1) / 100 | 0) + ((b - 1) / 400 | 0), e = c - d, f = e + 1, g = m + ((153 * (l - 3) + 2) / 5 | 0) + 58 + e), h = (b + c) % 7, m = (g + h - f) % 7, i = g + 3 - m, j = 0 > i ? 53 - ((h - e) / 5 | 0) : i > 364 + e ? 1 : (i / 7 | 0) + 1
            }, hb = {
                init: function () {
                    this.name = this.searchString(this.dataBrowser) || "", this.version = this.searchVersion(navigator.userAgent) || this.searchVersion(navigator.appVersion) || ""
                },
                searchString: function (a) {
                    for (var b = 0; b < a.length; b++) {
                        var c = a[b].string,
                            d = a[b].prop;
                        if (this.versionSearchString = a[b].versionSearch || a[b].identity, c) {
                            if (-1 != c.indexOf(a[b].subString)) return a[b].identity
                        } else if (d) return a[b].identity
                    }
                },
                searchVersion: function (a) {
                    var b = a.indexOf(this.versionSearchString);
                    if (-1 != b) return parseFloat(a.substring(b + this.versionSearchString.length + 1))
                },
                dataBrowser: [{
                    string: navigator.userAgent,
                    subString: "Firefox",
                    identity: "firefox"
                }, {
                    string: navigator.userAgent,
                    subString: "MSIE",
                    identity: "explorer",
                    versionSearch: "MSIE"
                }]
            };
        hb.init(), Q()
    }, a.fn.Zebra_DatePicker = function (b) {
        return this.each(function () {
            void 0 !== a(this).data("Zebra_DatePicker") && a(this).data("Zebra_DatePicker").destroy();
            var c = new a.Zebra_DatePicker(this, b);
            a(this).data("Zebra_DatePicker", c)
        })
    }
}(jQuery);