if (window.PrimeFaces) {
    /** Norwegian */
    PrimeFaces.locales["no"] = {
        accept: "Ja",
        addRule: "Legg til regel",
        am: "am",
        apply: "Bruk",
        cancel: "Avbryt",
        choose: "Velg",
        chooseDate: "Velg dato",
        chooseMonth: "Velg måned",
        chooseYear: "Velg år",
        clear: "Tøm",
        completed: "Ferdig",
        contains: "Inneholder",
        custom: "Egendefinert",
        dateAfter: "Dato er etter",
        dateBefore: "Dato er før",
        dateFormat: "dd.mm.yy",
        dateIs: "Dato er",
        dateIsNot: "Dato er ikke",
        dayNames: ["Søndag", "Mandag", "Tirsdag", "Onsdag", "Torsdag", "Fredag", "Lørdag"],
        dayNamesMin: ["Sø", "Ma", "Ti", "On", "To", "Fr", "Lø"],
        dayNamesShort: ["Søn", "Man", "Tir", "Ons", "Tor", "Fre", "Lør"],
        emptyFilterMessage: "Ingen resultater funnet",
        emptyMessage: "Ingen tilgjengelige valg",
        emptySearchMessage: "Ingen resultater funnet",
        emptySelectionMessage: "Ingen valgte oppføringer",
        endsWith: "Slutter på",
        equals: "Er lik",
        fileSizeTypes: ["B", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"],
        filter: "Filter",
        firstDayOfWeek: 1,
        gt: "Større enn",
        gte: "Større enn eller lik",
        lt: "Mindre enn",
        lte: "Mindre enn eller lik",
        matchAll: "Matcher alle",
        matchAny: "Matcher noen",
        medium: "Middels",
        monthNames: ["Januar", "Februar", "Mars", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Desember"],
        monthNamesShort: ["Jan", "Feb", "Mar", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Des"],
        nextDecade: "Nest årtiende",
        nextHour: "Neste time",
        nextMinute: "Neste minutt",
        nextMonth: "Neste måned",
        nextSecond: "Neste sekund",
        nextYear: "Neste år",
        noFilter: "Ikke filtrert",
        notContains: "Inneholder ikke",
        notEquals: "Er ikke lik",
        now: "Nå",
        passwordPrompt: "Skriv et passord",
        pending: "Venter",
        pm: "pm",
        prevDecade: "Forrige årtiende",
        prevHour: "Forrige time",
        prevMinute: "Forrige minutt",
        prevMonth: "Forrige måned",
        prevSecond: "Forrige sekund",
        prevYear: "Forrige år",
        reject: "Nei",
        removeRule: "Fjern regel",
        searchMessage: "{0} resultater er tilgjengelige",
        selectionMessage: "{0} oppføringer valgt",
        showMonthAfterYear: false,
        startsWith: "Starter med",
        strong: "Sterkt",
        today: "I dag",
        upload: "Last opp",
        weak: "Svakt",
        weekHeader: "Uke",
        aria: {
            cancelEdit: "Avbryt redigering",
            close: "Lukk",
            collapseLabel: "Kollapse",
            collapseRow: "Rad kollapset",
            editRow: "Rediger rad",
            expandLabel: "Utvide",
            expandRow: "Rad utvidet",
            falseLabel: "Av",
            filterConstraint: "Filterbegrensning",
            filterOperator: "Filteroperator",
            firstPageLabel: "Første side",
            gridView: "Rutenettsvisning",
            hideFilterMenu: "Skjul filtermeny",
            jumpToPageDropdownLabel: "Hopp til nestrekksmeny for side",
            jumpToPageInputLabel: "Hopp til sideledetekst",
            lastPageLabel: "Siste side",
            listView: "Listevisning",
            moveAllToSource: "Flytt alle til kilde",
            moveAllToTarget: "Flytt alle til mål",
            moveBottom: "Flytt til bunnen",
            moveDown: "Flytt ned",
            moveTop: "Flytt til toppen",
            moveToSource: "Flytt til kilde",
            moveToTarget: "Flytt til mål",
            moveUp: "Flytt opp",
            navigation: "Navigasjon",
            next: "Neste",
            nextPageLabel: "Neste side",
            nullLabel: "Ikke valgt",
            otpLabel: "Skriv inn engangspassordtegnet {0}",
            pageLabel: "Side {page}",
            passwordHide: "Skjul passord",
            passwordShow: "Vis passord",
            previous: "Forrige",
            previousPageLabel: "Forrige side",
            rotateLeft: "Roter til venstre",
            rotateRight: "Roter til høyre",
            rowsPerPageLabel: "Rader per side",
            saveEdit: "Lagre redigering",
            scrollTop: "Skroll til toppen",
            selectAll: "Alle oppføringer valgt",
            selectLabel: "Plukke ut",
            selectRow: "Rad valgt",
            showFilterMenu: "Vis filtermeny",
            slide: "Bilde",
            slideNumber: "{slideNumber}",
            star: "1 stjerne",
            stars: "{star} stjerner",
            trueLabel: "På",
            unselectAll: "Ingen oppføringer valgt",
            unselectLabel: "Fjern valget",
            unselectRow: "Rad ikke valgt",
            zoomImage: "Forstørr bilde",
            zoomIn: "Forstørr",
            zoomOut: "Forminsk",
        },
    };

    // custom PF labels
    PrimeFaces.locales["no"] = $.extend(true, {}, PrimeFaces.locales["no"], {
        isRTL: false,
        yearSuffix: "",
        timeOnlyTitle: "Kun tid",
        timeText: "Tid",
        hourText: "Time",
        minuteText: "Minutt",
        secondText: "Sekund",
        millisecondText: "Millisekund",
        month: "Måned",
        week: "uke",
        day: "Dag",
        allDayText: "Hele dagen",
        aria: {
            "datatable.sort.ASC": "aktiver for å sortere kolonne stigende",
            "datatable.sort.DESC": "aktiver for å sortere kolonne synkende",
            "datatable.sort.NONE": "aktiver for å fjerne sortering på kolonne",
            "colorpicker.OPEN": "Åpne fargevelger",
            "colorpicker.CLOSE": "Lukk fargevelger",
            "colorpicker.CLEAR": "Slett den valgte fargen",
            "colorpicker.MARKER": "Metning: {s}. Lysstyrke: {v}.",
            "colorpicker.HUESLIDER": "Glider for fargetone",
            "colorpicker.ALPHASLIDER": "Opasitetsglidebryter",
            "colorpicker.INPUT": "Fargeverdifelt",
            "colorpicker.FORMAT": "Fargeformat",
            "colorpicker.SWATCH": "Fargeprøve",
            "colorpicker.INSTRUCTION": "Velger for metning og lysstyrke. Bruk opp, ned, venstre og høyre piltaster for å velge.",
            "spinner.INCREASE": "Øk verdien",
            "spinner.DECREASE": "Reduser verdi",
            "switch.ON": "På",
            "switch.OFF": "Av",
            "messages.ERROR": "Feil",
            "messages.FATAL": "Dødelig",
            "messages.INFO": "Informasjon",
            "messages.WARN": "Advarsel",
        },
        messages: {
            "javax.faces.component.UIInput.REQUIRED": "{0}: Valideringsfeil: Verdi er påkrevd.",
            "javax.faces.converter.IntegerConverter.INTEGER": "{2}: '{0}' må være et tall som består av ett eller flere sifre.",
            "javax.faces.converter.IntegerConverter.INTEGER_detail": "{2}: '{0}' må være et tall mellom -2147483648 og 2147483647. Eksempel: {1}.",
            "javax.faces.converter.DoubleConverter.DOUBLE": "{2}: '{0}' må være et tall som består av ett eller flere sifre.",
            "javax.faces.converter.DoubleConverter.DOUBLE_detail": "{2}: '{0}' må være et tall mellom 4.9E-324 og 1.7976931348623157E308. Eksempel: {1}.",
            "javax.faces.converter.BigDecimalConverter.DECIMAL": "{2}: '{0}' må være et signert desimaltall.",
            "javax.faces.converter.BigDecimalConverter.DECIMAL_detail": "{2}: '{0}' må være et fortegnet desimaltall som består av null eller flere sifre, som kan følges av et desimaltegn og brøk. Eksempel: {1 }.",
            "javax.faces.converter.BigIntegerConverter.BIGINTEGER": "{2}: '{0}' må være et tall som består av ett eller flere sifre.",
            "javax.faces.converter.BigIntegerConverter.BIGINTEGER_detail": "{2}: '{0}' må være et tall som består av ett eller flere sifre. Eksempel: {1}.",
            "javax.faces.converter.ByteConverter.BYTE": "{2}: '{0}' må være et tall mellom 0 og 255.",
            "javax.faces.converter.ByteConverter.BYTE_detail": "{2}: '{0}' må være et tall mellom 0 og 255. Eksempel: {1}.",
            "javax.faces.converter.CharacterConverter.CHARACTER": "{1}: '{0}' må være et gyldig tegn.",
            "javax.faces.converter.CharacterConverter.CHARACTER_detail": "{1}: '{0}' må være et gyldig ASCII-tegn.",
            "javax.faces.converter.ShortConverter.SHORT": "{2}: '{0}' må være et tall som består av ett eller flere sifre.",
            "javax.faces.converter.ShortConverter.SHORT_detail": "{2}: '{0}' må være et tall mellom -32768 og 32767. Eksempel: {1}.",
            "javax.faces.converter.BooleanConverter.BOOLEAN": "{1}: '{0}' må være 'true' eller 'false'.",
            "javax.faces.converter.BooleanConverter.BOOLEAN_detail": "{1}: '{0}' må være 'true' eller 'false'. Alle andre verdier enn 'true' vil evalueres til 'false'.",
            "javax.faces.validator.LongRangeValidator.MAXIMUM": "{1}: Valideringsfeil: Verdien er større enn tillatt maksimum på '{0}'.",
            "javax.faces.validator.LongRangeValidator.MINIMUM": "{1}: Valideringsfeil: Verdien er mindre enn tillatt minimum på '{0}'.",
            "javax.faces.validator.LongRangeValidator.NOT_IN_RANGE": "{2}: Valideringsfeil: Spesifisert attributt er ikke mellom de forventede verdiene for {0} og {1}.",
            "javax.faces.validator.LongRangeValidator.TYPE": "{0}: Valideringsfeil: Verdien er ikke av riktig type.",
            "javax.faces.validator.DoubleRangeValidator.MAXIMUM": "{1}: Valideringsfeil: Verdien er større enn tillatt maksimum på '{0}'.",
            "javax.faces.validator.DoubleRangeValidator.MINIMUM": "{1}: Valideringsfeil: Verdien er mindre enn tillatt minimum på '{0}'.",
            "javax.faces.validator.DoubleRangeValidator.NOT_IN_RANGE": "{2}: Valideringsfeil: Spesifisert attributt er ikke mellom de forventede verdiene for {0} og {1}.",
            "javax.faces.validator.DoubleRangeValidator.TYPE": "{0}: Valideringsfeil: Verdien er ikke av riktig type.",
            "javax.faces.converter.FloatConverter.FLOAT": "{2}: '{0}' må være et tall som består av ett eller flere sifre.",
            "javax.faces.converter.FloatConverter.FLOAT_detail": "{2}: '{0}' må være et tall mellom 1.4E-45 og 3.4028235E38 Eksempel: {1}.",
            "javax.faces.converter.DateTimeConverter.DATE": "{2}: '{0}' kunne ikke forstås som en dato.",
            "javax.faces.converter.DateTimeConverter.DATE_detail": "{2}: '{0}' kunne ikke forstås som en dato. Eksempel: {1}.",
            "javax.faces.converter.DateTimeConverter.TIME": "{2}: '{0}' kunne ikke forstås som en tid.",
            "javax.faces.converter.DateTimeConverter.TIME_detail": "{2}: '{0}' kunne ikke forstås som en tid. Eksempel: {1}.",
            "javax.faces.converter.DateTimeConverter.DATETIME": "{2}: '{0}' kunne ikke forstås som en dato og et klokkeslett.",
            "javax.faces.converter.DateTimeConverter.DATETIME_detail": "{2}: '{0}' kunne ikke forstås som en dato og tid. Eksempel: {1}.",
            "javax.faces.converter.DateTimeConverter.PATTERN_TYPE": "{1}: Et 'pattern'- eller 'type'-attributt må spesifiseres for å konvertere verdien '{0}'.",
            "javax.faces.converter.NumberConverter.CURRENCY": "{2}: '{0}' kunne ikke forstås som en valutaverdi.",
            "javax.faces.converter.NumberConverter.CURRENCY_detail": "{2}: '{0}' kunne ikke forstås som en valutaverdi. Eksempel: {1}.",
            "javax.faces.converter.NumberConverter.PERCENT": "{2}: '{0}' kunne ikke forstås som en prosentandel.",
            "javax.faces.converter.NumberConverter.PERCENT_detail": "{2}: '{0}' kunne ikke forstås som en prosentandel. Eksempel: {1}.",
            "javax.faces.converter.NumberConverter.NUMBER": "{2}: '{0}' kunne ikke forstås som et tall.",
            "javax.faces.converter.NumberConverter.NUMBER_detail": "{2}: '{0}' kunne ikke forstås som et tall. Eksempel: {1}.",
            "javax.faces.converter.NumberConverter.PATTERN": "{2}: '{0}' kunne ikke forstås som et tallmønster.",
            "javax.faces.converter.NumberConverter.PATTERN_detail": "{2}: '{0}' kunne ikke forstås som et tallmønster. Eksempel: {1}.",
            "javax.faces.validator.LengthValidator.MINIMUM": "{1}: Valideringsfeil: Lengden er mindre enn tillatt minimum på '{0}'.",
            "javax.faces.validator.LengthValidator.MAXIMUM": "{1}: Valideringsfeil: Lengden er større enn tillatt maksimum på '{0}'.",
            "javax.faces.validator.RegexValidator.PATTERN_NOT_SET": "Regex-mønster må angis.",
            "javax.faces.validator.RegexValidator.PATTERN_NOT_SET_detail": "Regex-mønster må settes til ikke-tom verdi.",
            "javax.faces.validator.RegexValidator.NOT_MATCHED": "Regex-mønster samsvarer ikke.",
            "javax.faces.validator.RegexValidator.NOT_MATCHED_detail": "Regex-mønsteret til '{0}' samsvarer ikke.",
            "javax.faces.validator.RegexValidator.MATCH_EXCEPTION": "Feil i regulære uttrykk.",
            "javax.faces.validator.RegexValidator.MATCH_EXCEPTION_detail": "Feil i regulære uttrykk, '{0}'.",
            "primefaces.FileValidator.FILE_LIMIT": "Maksimalt antall filer er overskredet.",
            "primefaces.FileValidator.FILE_LIMIT_detail": "Maksimalt antall: {0}.",
            "primefaces.FileValidator.ALLOW_TYPES": "Ugyldig filtype.",
            "primefaces.FileValidator.ALLOW_TYPES_detail": "Ugyldig filtype: '{0}'. Tillatte typer: '{1}'.",
            "primefaces.FileValidator.SIZE_LIMIT": "Ugyldig filstørrelse.",
            "primefaces.FileValidator.SIZE_LIMIT_detail": "Filen '{0}' må ikke være større enn {1}.",
            //valgfritt for integrasjon av bønnevalidering i validering på klientsiden
            "javax.faces.validator.BeanValidator.MESSAGE": "{0}",
            "javax.validation.constraints.AssertFalse.message": "må være usann",
            "javax.validation.constraints.AssertTrue.message": "må være sant",
            "javax.validation.constraints.DecimalMax.message": "må være mindre enn eller lik {0}",
            "javax.validation.constraints.DecimalMin.message": "må være større enn eller lik {0}",
            "javax.validation.constraints.Digits.message": "numerisk verdi utenfor grensene (&lt;{0} sifre&gt;.&lt;{1} sifre&gt; forventet)",
            "javax.validation.constraints.Email.message": "må være en godt utformet e-postadresse",
            "javax.validation.constraints.Future.message": "må være en fremtidig dato",
            "javax.validation.constraints.FutureOrPresent.message": "må være en dato i nåtiden eller i fremtiden",
            "javax.validation.constraints.Max.message": "må være mindre enn eller lik {0}",
            "javax.validation.constraints.Min.message": "må være større enn eller lik {0}",
            "javax.validation.constraints.Negative.message": "må være mindre enn 0",
            "javax.validation.constraints.NegativeOrZero.message": "må være mindre enn eller lik 0",
            "javax.validation.constraints.NotBlank.message": "må ikke være blank",
            "javax.validation.constraints.NotEmpty.message": "må ikke være tom",
            "javax.validation.constraints.NotNull.message": "må ikke være null",
            "javax.validation.constraints.Null.message": "må være null",
            "javax.validation.constraints.Past.message": "må være en tidligere dato",
            "javax.validation.constraints.PastOrPresent.message": "må være en dato i fortiden eller i nåtiden",
            "javax.validation.constraints.Pattern.message": "må samsvare med &#39;{0}&#39;",
            "javax.validation.constraints.Positive.message": "må være større enn 0",
            "javax.validation.constraints.PositiveOrZero.message": "må være større enn eller lik 0",
            "javax.validation.constraints.Size.message": "størrelsen må være mellom {0} og {1}",
        },
    });
    PrimeFaces.locales["nb_NO"] = PrimeFaces.locales["no"];
}
