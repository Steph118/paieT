if (window.PrimeFaces) {
  /** Slovak */
  PrimeFaces.locales["sk"] = {
    accept: "Áno",
    addRule: "Pridať pravidlo",
    am: "ráno",
    apply: "Použiť",
    cancel: "Zrušiť",
    choose: "Vybrať",
    chooseDate: "Vyberte dátum",
    chooseMonth: "Vyberte mesiac",
    chooseYear: "Vyberte rok",
    clear: "Vyčistiť",
    completed: "Dokončené",
    contains: "Obsahuje",
    custom: "Vlastné",
    dateAfter: "Dátum je po",
    dateBefore: "Dátum je pred",
    dateFormat: "dd.mm.rrrr",
    dateIs: "Dátum je",
    dateIsNot: "Dátum nie je",
    dayNames: ["Nedeľa", "Pondelok", "Utorok", "Streda", "Štvrtok", "Piatok", "Sobota"],
    dayNamesMin: ["Ne", "Po", "Ut", "St", "Št", "Pi", "So"],
    dayNamesShort: ["Ned", "Pon", "Uto", "Str", "Štv", "Pia", "Sob"],
    emptyFilterMessage: "Neboli nájdené žiadne výsledky",
    emptyMessage: "Žiadne dostupné možnosti",
    emptySearchMessage: "Neboli nájdené žiadne výsledky",
    emptySelectionMessage: "Žiadna vybraná položka",
    endsWith: "Končí na",
    equals: "Rovná sa",
    fileSizeTypes: ["B", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"],
    filter: "Filter",
    firstDayOfWeek: 1,
    gt: "Väčšie než",
    gte: "Väčšie než alebo rovné",
    lt: "Menšie než",
    lte: "Menšie než alebo rovné",
    matchAll: "Zodpovedá všetkým",
    matchAny: "Zodpovedá akémukoľvek",
    medium: "Stredné",
    monthNames: ["Január", "Február", "Marec", "Apríl", "Máj", "Jún", "Júl", "August", "September", "Október", "November", "December"],
    monthNamesShort: ["Jan", "Feb", "Mar", "Apr", "Máj", "Jún", "Júl", "Aug", "Sep", "Okt", "Nov", "Dec"],
    nextDecade: "Nasledujúce desaťročie",
    nextHour: "Nasledujúca hodina",
    nextMinute: "Nasledujúca minúta",
    nextMonth: "Nasledujúci mesiac",
    nextSecond: "Nasledujúca sekunda",
    nextYear: "Nasledujúci rok",
    noFilter: "Bez filtra",
    notContains: "Neobsahuje",
    notEquals: "Nerovná sa",
    now: "Teraz",
    passwordPrompt: "Zadejte heslo",
    pending: "Čakajúce",
    pm: "popoludní",
    prevDecade: "Predchádzajúce desaťročie",
    prevHour: "Predchádzajúca hodina",
    prevMinute: "Predchádzajúca minúta",
    prevMonth: "Predchádzajúci mesiac",
    prevSecond: "Predchádzajúca sekunda",
    prevYear: "Predchádzajúci rok",
    reject: "Nie",
    removeRule: "Odstrániť pravidlo",
    searchMessage: "Je k dispozícií {0} výsledkov",
    selectionMessage: "Vybraných {0} položiek",
    showMonthAfterYear: false,
    startsWith: "Začína na",
    strong: "Silné",
    today: "Dnes",
    upload: "Nahrať súbor",
    weak: "Slabé",
    weekHeader: "Týž.",
    aria: {
      cancelEdit: "Zrušiť úpravu",
      close: "Zavrieť",
      collapseLabel: "kolaps",
      collapseRow: "Zbaliť riadok",
      editRow: "Upraviť riadok",
      expandLabel: "Rozbaliť",
      expandRow: "Rozbaliť riadok",
      falseLabel: "Nepravda",
      filterConstraint: "Obmedzenie filtra",
      filterOperator: "Operátor filtra",
      firstPageLabel: "Prvá strana",
      gridView: "Zobrazenie mriežky",
      hideFilterMenu: "Skryť filter menu",
      jumpToPageDropdownLabel: "Prejsť na stránku Dropdown",
      jumpToPageInputLabel: "Prejsť na stránku Input",
      lastPageLabel: "Posledná strana",
      listView: "Zobrazenie zoznamu",
      moveAllToSource: "Presunúť všetko ku zdroju",
      moveAllToTarget: "Presunúť všetko na cieľ",
      moveBottom: "Presunúť dole",
      moveDown: "Presunúť dole",
      moveTop: "Presunúť hore",
      moveToSource: "Presunúť ku zdroju",
      moveToTarget: "Presunúť na cieľ",
      moveUp: "Presunúť hore",
      navigation: "Navigácia",
      next: "Ďalší",
      nextPageLabel: "Dalšia strana",
      nullLabel: "Nevybrané",
      otpLabel: "Zadajte jednorazový znak hesla {0}",
      pageLabel: "{page}",
      passwordHide: "Skryť heslo",
      passwordShow: "Ukázať heslo",
      previous: "Predchádzajúci",
      previousPageLabel: "Predchádzajúca strana",
      rotateLeft: "Otočiť doľava",
      rotateRight: "Otočiť doprava",
      rowsPerPageLabel: "Riadkov na stranu",
      saveEdit: "Uložiť úpravu",
      scrollTop: "Posunúť hore",
      selectAll: "Všetky položky vybrané",
      selectLabel: "Vyberte",
      selectRow: "Vybrať riadok",
      showFilterMenu: "Zobraziť filter menu",
      slide: "Snímka",
      slideNumber: "{slideNumber}",
      star: "1 hviezda",
      stars: "{star} hviezd",
      trueLabel: "Pravda",
      unselectAll: "Všetky položky zrušené",
      unselectLabel: "Zrušte výber",
      unselectRow: "Zrušiť výber riadku",
      zoomImage: "Priblížiť obrázok",
      zoomIn: "Priblížiť",
      zoomOut: "Oddialiť",
    },
  };

  // custom PF labels
  PrimeFaces.locales["sk"] = $.extend(true, {}, PrimeFaces.locales["sk"], {
    allDayText: "Celý deň",
    day: "Deň",
    hourText: "Hodina",
    isRTL: false,
    list: "Agenda",
    millisecondText: "Milisekunda",
    minuteText: "Minúta",
    month: "Mesiac",
    moreLinkText: "Viac...",
    noEventsText: "Žiadne udalosti",
    secondText: "Sekunda",
    timeOnlyTitle: "Len čas",
    timeText: "Čas",
    unexpectedError: "Neočakávaná chyba",
    week: "Týždeň",
    weekNumberTitle: "IN",
    year: "rok",
    yearSuffix: "",
    aria: {
      "colorpicker.ALPHASLIDER": "Posúvač nepriehľadnosti",
      "colorpicker.CLEAR": "Vymazať vybranú farbu",
      "colorpicker.CLOSE": "Zavrieť výber farieb",
      "colorpicker.FORMAT": "Formát farieb",
      "colorpicker.HUESLIDER": "Posúvač odtieňa",
      "colorpicker.INPUT": "Pole hodnoty farby",
      "colorpicker.INSTRUCTION": "Výber sýtosti a jasu. Na výber použite klávesy so šípkou nahor, nadol, doľava a doprava.",
      "colorpicker.MARKER": "Sýtosť: {s}. Jas: {v}.",
      "colorpicker.OPEN": "Otvoriť výber farieb",
      "colorpicker.SWATCH": "Vzorka farieb",
      "datatable.sort.ASC": "aktiváciou zoradiť stĺpec vzostupne",
      "datatable.sort.DESC": "aktiváciou zoradiť stĺpec zostupne",
      "datatable.sort.NONE": "aktiváciou odstránite triedenie v stĺpci",
      "messages.ERROR": "Chyba",
      "messages.FATAL": "Osudné",
      "messages.INFO": "Informácie",
      "messages.WARN": "Upozornenie",
      "spinner.DECREASE": "Znížiť hodnotu",
      "spinner.INCREASE": "Zvýšiť hodnotu",
      "switch.OFF": "Off",
      "switch.ON": "Zapnuté",
    },
    messages: {
      "javax.faces.component.UIInput.REQUIRED": "{0}: Chyba overenia: Vyžaduje sa hodnota.",
      "javax.faces.converter.BigDecimalConverter.DECIMAL": "{2}: '{0}' musí byť desiatkové číslo so znamienkom.",
      "javax.faces.converter.BigDecimalConverter.DECIMAL_detail": "{2}: '{0}' musí byť desiatkové číslo so znamienkom pozostávajúce z nuly alebo viacerých číslic, za ktorými môže nasledovať desatinná čiarka a zlomok. Príklad: {1 }.",
      "javax.faces.converter.BigIntegerConverter.BIGINTEGER": "{2}: '{0}' musí byť číslo pozostávajúce z jednej alebo viacerých číslic.",
      "javax.faces.converter.BigIntegerConverter.BIGINTEGER_detail": "{2}: '{0}' musí byť číslo pozostávajúce z jednej alebo viacerých číslic. Príklad: {1}.",
      "javax.faces.converter.BooleanConverter.BOOLEAN": "{1}: '{0}' musí byť 'true' alebo 'false'.",
      "javax.faces.converter.BooleanConverter.BOOLEAN_detail": "{1}: '{0}' musí byť 'true' alebo 'false'. Akákoľvek hodnota iná ako 'true' bude vyhodnotená ako 'false'.",
      "javax.faces.converter.ByteConverter.BYTE": "{2}: '{0}' musí byť číslo medzi 0 a 255.",
      "javax.faces.converter.ByteConverter.BYTE_detail": "{2}: '{0}' musí byť číslo od 0 do 255. Príklad: {1}.",
      "javax.faces.converter.CharacterConverter.CHARACTER": "{1}: '{0}' musí byť platný znak.",
      "javax.faces.converter.CharacterConverter.CHARACTER_detail": "{1}: '{0}' musí byť platný znak ASCII.",
      "javax.faces.converter.DateTimeConverter.DATE": "{2}: '{0}' nemožno chápať ako dátum.",
      "javax.faces.converter.DateTimeConverter.DATE_detail": "{2}: '{0}' nemožno chápať ako dátum. Príklad: {1}.",
      "javax.faces.converter.DateTimeConverter.DATETIME": "{2}: '{0}' nemožno chápať ako dátum a čas.",
      "javax.faces.converter.DateTimeConverter.DATETIME_detail": "{2}: '{0}' nemožno pochopiť ako dátum a čas. Príklad: {1}.",
      "javax.faces.converter.DateTimeConverter.PATTERN_TYPE": "{1}: Na konverziu hodnoty '{0}' je potrebné zadať atribút 'pattern' alebo 'type'.",
      "javax.faces.converter.DateTimeConverter.TIME": "{2}: '{0}' nemožno chápať ako čas.",
      "javax.faces.converter.DateTimeConverter.TIME_detail": "{2}: '{0}' nemožno chápať ako čas. Príklad: {1}.",
      "javax.faces.converter.DoubleConverter.DOUBLE": "{2}: '{0}' musí byť číslo pozostávajúce z jednej alebo viacerých číslic.",
      "javax.faces.converter.DoubleConverter.DOUBLE_detail": "{2}: '{0}' musí byť číslo medzi 4,9E-324 a 1,7976931348623157E308. Príklad: {1}.",
      "javax.faces.converter.FloatConverter.FLOAT": "{2}: '{0}' musí byť číslo pozostávajúce z jednej alebo viacerých číslic.",
      "javax.faces.converter.FloatConverter.FLOAT_detail": "{2}: '{0}' musí byť číslo medzi 1.4E-45 a 3.4028235E38 Príklad: {1}.",
      "javax.faces.converter.IntegerConverter.INTEGER": "{2}: '{0}' musí byť číslo pozostávajúce z jednej alebo viacerých číslic.",
      "javax.faces.converter.IntegerConverter.INTEGER_detail": "{2}: '{0}' musí byť číslo medzi -2147483648 a 2147483647. Príklad: {1}.",
      "javax.faces.converter.NumberConverter.CURRENCY": "{2}: '{0}' nemožno chápať ako hodnotu meny.",
      "javax.faces.converter.NumberConverter.CURRENCY_detail": "{2}: '{0}' nemožno chápať ako hodnotu meny. Príklad: {1}.",
      "javax.faces.converter.NumberConverter.NUMBER": "{2}: '{0}' nemožno chápať ako číslo.",
      "javax.faces.converter.NumberConverter.NUMBER_detail": "{2}: '{0}' nemožno chápať ako číslo. Príklad: {1}.",
      "javax.faces.converter.NumberConverter.PATTERN": "{2}: '{0}' nemožno pochopiť ako číselný vzor.",
      "javax.faces.converter.NumberConverter.PATTERN_detail": "{2}: '{0}' nemožno chápať ako číselný vzor. Príklad: {1}.",
      "javax.faces.converter.NumberConverter.PERCENT": "{2}: '{0}' nemožno pochopiť ako percento.",
      "javax.faces.converter.NumberConverter.PERCENT_detail": "{2}: '{0}' nemožno pochopiť ako percento. Príklad: {1}.",
      "javax.faces.converter.ShortConverter.SHORT": "{2}: '{0}' musí byť číslo pozostávajúce z jednej alebo viacerých číslic.",
      "javax.faces.converter.ShortConverter.SHORT_detail": "{2}: '{0}' musí byť číslo medzi -32768 a 32767. Príklad: {1}.",
      "javax.faces.validator.BeanValidator.MESSAGE": "{0}",
      "javax.faces.validator.DoubleRangeValidator.MAXIMUM": "{1}: Chyba overenia: Hodnota je väčšia než povolené maximum '{0}'.",
      "javax.faces.validator.DoubleRangeValidator.MINIMUM": "{1}: Chyba overenia: Hodnota je menšia než povolené minimum '{0}'.",
      "javax.faces.validator.DoubleRangeValidator.NOT_IN_RANGE": "{2}: Chyba overenia: Zadaný atribút nie je medzi očakávanými hodnotami {0} a {1}.",
      "javax.faces.validator.DoubleRangeValidator.TYPE": "{0}: Chyba overenia: Hodnota nie je správneho typu.",
      "javax.faces.validator.LengthValidator.MAXIMUM": "{1}: Chyba overenia: Dĺžka je väčšia ako povolené maximum '{0}'.",
      "javax.faces.validator.LengthValidator.MINIMUM": "{1}: Chyba overenia: Dĺžka je menšia ako povolené minimum '{0}'.",
      "javax.faces.validator.LongRangeValidator.MAXIMUM": "{1}: Chyba overenia: Hodnota je väčšia ako povolené maximum '{0}'.",
      "javax.faces.validator.LongRangeValidator.MINIMUM": "{1}: Chyba overenia: Hodnota je menšia ako povolené minimum '{0}'.",
      "javax.faces.validator.LongRangeValidator.NOT_IN_RANGE": "{2}: Chyba overenia: Zadaný atribút nie je medzi očakávanými hodnotami {0} a {1}.",
      "javax.faces.validator.LongRangeValidator.TYPE": "{0}: Chyba overenia: Hodnota nie je správneho typu.",
      "javax.faces.validator.RegexValidator.MATCH_EXCEPTION": "Chyba v regulárnom výraze.",
      "javax.faces.validator.RegexValidator.MATCH_EXCEPTION_detail": "Chyba v regulárnom výraze, '{0}'.",
      "javax.faces.validator.RegexValidator.NOT_MATCHED": "Vzor regulárneho výrazu sa nezhoduje.",
      "javax.faces.validator.RegexValidator.NOT_MATCHED_detail": "Vzor regulárneho výrazu '{0}' sa nezhoduje.",
      "javax.faces.validator.RegexValidator.PATTERN_NOT_SET": "Musí byť nastavený vzor regulárneho výrazu.",
      "javax.faces.validator.RegexValidator.PATTERN_NOT_SET_detail": "Vzor regulárneho výrazu musí byť nastavený na neprázdnu hodnotu.",
      "javax.validation.constraints.AssertFalse.message": "musí byť nepravdivé",
      "javax.validation.constraints.AssertTrue.message": "musí byť pravda",
      "javax.validation.constraints.DecimalMax.message": "musí byť menšie alebo rovné {0}",
      "javax.validation.constraints.DecimalMin.message": "musí byť väčšie alebo rovné {0}",
      "javax.validation.constraints.Digits.message": "číselná hodnota je mimo rozsahu (&lt;{0} číslic&gt;. &lt;{1} číslic&gt; očakáva sa)",
      "javax.validation.constraints.Email.message": "musí to byť správna e-mailová adresa",
      "javax.validation.constraints.Future.message": "musí to byť budúci dátum",
      "javax.validation.constraints.FutureOrPresent.message": "musí to byť dátum v súčasnosti alebo v budúcnosti",
      "javax.validation.constraints.Max.message": "musí byť menšie alebo rovné {0}",
      "javax.validation.constraints.Min.message": "musí byť väčšie alebo rovné {0}",
      "javax.validation.constraints.Negative.message": "musí byť menšia ako 0",
      "javax.validation.constraints.NegativeOrZero.message": "musí byť menšie alebo rovné 0",
      "javax.validation.constraints.NotBlank.message": "nesmie byť prázdne",
      "javax.validation.constraints.NotEmpty.message": "nesmie byť prázdny",
      "javax.validation.constraints.NotNull.message": "nesmie byť nulové",
      "javax.validation.constraints.Null.message": "musí byť nulové",
      "javax.validation.constraints.Past.message": "musí to byť minulý dátum",
      "javax.validation.constraints.PastOrPresent.message": "musí to byť dátum v minulosti alebo v súčasnosti",
      "javax.validation.constraints.Pattern.message": "musí zodpovedať &#39;{0}&#39;",
      "javax.validation.constraints.Positive.message": "musí byť väčšia ako 0",
      "javax.validation.constraints.PositiveOrZero.message": "musí byť väčšie alebo rovné 0",
      "javax.validation.constraints.Size.message": "veľkosť musí byť medzi {0} a {1}",
      "primefaces.FileValidator.ALLOW_TYPES": "Neplatný typ súboru.",
      "primefaces.FileValidator.ALLOW_TYPES_detail": "Neplatný typ súboru: '{0}'. Povolené typy: '{1}'.",
      "primefaces.FileValidator.FILE_LIMIT": "Bol prekročený maximálny počet súborov.",
      "primefaces.FileValidator.FILE_LIMIT_detail": "Maximálny počet: {0}.",
      "primefaces.FileValidator.SIZE_LIMIT": "Neplatná veľkosť súboru.",
      "primefaces.FileValidator.SIZE_LIMIT_detail": "Súbor '{0}' nesmie byť väčší ako {1}.",
    },
  });
}
